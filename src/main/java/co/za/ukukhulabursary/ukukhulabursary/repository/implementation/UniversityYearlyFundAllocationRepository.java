package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityYearlyFundAllocationDTO;
import co.za.ukukhulabursary.ukukhulabursary.mapper.UniversityYearlyFundAllocationMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;
import co.za.ukukhulabursary.ukukhulabursary.repository.IRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UniversityYearlyFundAllocationRepository implements IRepository<UniversityYearlyFundAllocation> {
    private final UniversityYearlyFundAllocationMapper universityYearlyFundAllocationMapper;

    private final JdbcTemplate jdbcTemplate;


    public List<UniversityYearlyFundAllocation> findAllUniversitiesFunding() {
        String sql = "SELECT * FROM [dbo].[vUniversityFundAllocation]";
        return jdbcTemplate.query(
                sql,
                universityYearlyFundAllocationMapper
        );
    }


    public List<UniversityYearlyFundAllocation> findAllUniversitiesFundingByYear(int year) {
        String sql = "SELECT * FROM [dbo].[vUniversityFundAllocation] WHERE YEAR([FinancialYearStart]) = ?";
        return jdbcTemplate.query(
                sql,
                universityYearlyFundAllocationMapper,
                year
        );
    }


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

    @Override
    public List<UniversityYearlyFundAllocation> findAll() {
        return null;
    }

    @Override
    public Optional<UniversityYearlyFundAllocation> findById(long id) {
        return Optional.empty();
    }
}
