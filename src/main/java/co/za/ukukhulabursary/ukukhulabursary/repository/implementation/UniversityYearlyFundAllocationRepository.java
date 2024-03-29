package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityMoneySpentDTO;
import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityYearlyFundAllocationDTO;
import co.za.ukukhulabursary.ukukhulabursary.mapper.UniversityMoneySpentMapper;
import co.za.ukukhulabursary.ukukhulabursary.mapper.UniversityYearlyFundAllocationMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;
import co.za.ukukhulabursary.ukukhulabursary.model.User;
import co.za.ukukhulabursary.ukukhulabursary.repository.IUniversityYearlyFundAllocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UniversityYearlyFundAllocationRepository implements IUniversityYearlyFundAllocationRepository {
    private final UniversityYearlyFundAllocationMapper universityYearlyFundAllocationMapper;
    private final UniversityMoneySpentMapper universityMoneySpentDTO;

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<UniversityYearlyFundAllocation> findAllUniversitiesFunding() {
        String sql = "SELECT * FROM [dbo].[vUniversityFundAllocation]";
        return jdbcTemplate.query(
                sql,
                universityYearlyFundAllocationMapper
        );
    }

    @Override
    public List<UniversityYearlyFundAllocation> findAllUniversitiesFundingByYear(int year) {
        String sql = "SELECT * FROM [dbo].[vUniversityFundAllocation] WHERE YEAR([FinancialYearStart]) = ?";
        return jdbcTemplate.query(
                sql,
                universityYearlyFundAllocationMapper,
                year
        );
    }

    @Override
    public List<UniversityYearlyFundAllocation> findUniversityFundingForYear(int year, long universityId) {
        String sql = "SELECT * FROM [dbo].[vUniversityFundAllocation] " +
                     "WHERE YEAR([FinancialYearStart]) = ? AND [UniversityId] = ?";
        return jdbcTemplate.query(
                sql,
                universityYearlyFundAllocationMapper,
                year,
                universityId
        );
    }

    @Override
    public List<UniversityMoneySpentDTO> findUniverityAndTheMoneyTheirSpent(int year) {
        String sql ="SELECT DISTINCT U.Name, UFA.Budget - UFA.RemainingBudget AS [Money Spent]\n" +
                "FROM University U\n" +
                "LEFT JOIN UniversityYearlyFundAllocation UFA ON U.UniversityID = UFA.UniversityID\n" +
                "LEFT JOIN BBDYearlyFund BYF ON UFA.YearlyFundID = BYF.YearlyFundID\n" +
                "WHERE YEAR(BYF.FinancialYearStart) = ?";

        return jdbcTemplate.query(sql, universityMoneySpentDTO, year);
    }

    @Override
    public Optional<UniversityMoneySpentDTO> UniverityChecksHowMuchTheirSpentEachYear(int year, int universityID) {
        String sql ="SELECT U.Name, SUM(UFA.Budget - UFA.RemainingBudget) AS [Money Spent]\n" +
                "FROM University U\n" +
                "LEFT JOIN UniversityYearlyFundAllocation UFA ON U.UniversityID = UFA.UniversityID\n" +
                "LEFT JOIN BBDYearlyFund BYF ON UFA.YearlyFundID = BYF.YearlyFundID\n" +
                "WHERE YEAR(BYF.FinancialYearStart) = ? AND U.UniversityID = ?\n" +
                "GROUP BY U.Name;";

        List<UniversityMoneySpentDTO> university = jdbcTemplate.query(sql, universityMoneySpentDTO, year,universityID);

        if (!university.isEmpty()){
            return  Optional.of(university.getFirst());
        }

        return Optional.empty();
    }

    @Override
    public void save(
            UniversityYearlyFundAllocationDTO universityYearlyFundAllocationDTO) {
        String sql = "INSERT INTO [dbo].[UniversityYearlyFundAllocation]" +
                     "([Budget], [RemainingBudget], [UniversityID], [YearlyFundID]) " +
                     "VALUES (?, ?, ?, ?)";
        Object[] args = new Object[] {
                universityYearlyFundAllocationDTO.getBudget(),
                universityYearlyFundAllocationDTO.getBudget(),
                universityYearlyFundAllocationDTO.getUniversityId(),
                universityYearlyFundAllocationDTO.getYearlyFundId()
        };
        jdbcTemplate.update(sql, args);
    }


}
