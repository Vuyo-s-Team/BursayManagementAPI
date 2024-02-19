package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityYearlyFundAllocationDTO;
import co.za.ukukhulabursary.ukukhulabursary.mapper.UniversityYearlyFundAllocationMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;
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
