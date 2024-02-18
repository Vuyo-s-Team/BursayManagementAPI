package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;
import co.za.ukukhulabursary.ukukhulabursary.repository.IUniversityRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UniversityYearlyFundAllocationMapper implements RowMapper<UniversityYearlyFundAllocation> {

    private final IUniversityRepository universityRepository;

    @Override
    public UniversityYearlyFundAllocation mapRow(ResultSet rs, int rowNum) throws SQLException {
        UniversityYearlyFundAllocation universityYearlyFundAllocation = new UniversityYearlyFundAllocation();
        if (rowNum > -1) {
            long univesityId = rs.getLong("UniversityID");
            universityYearlyFundAllocation.setId(univesityId);
            universityYearlyFundAllocation.setMoney(rs.getDouble("Budget"));
            universityYearlyFundAllocation.setRemainingBudget(rs.getDouble("RemainingBudget"));

            Optional<University> university = universityRepository.findById(univesityId);

            university.ifPresent(universityYearlyFundAllocation::setUniversity);

            universityYearlyFundAllocation.setDate(rs.getDate("FinancialYearStart").toLocalDate());
        }
        return universityYearlyFundAllocation;
    }
}
