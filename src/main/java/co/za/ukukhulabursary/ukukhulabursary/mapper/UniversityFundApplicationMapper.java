package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.exception.StatusNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.Status;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityFundApplication;
import co.za.ukukhulabursary.ukukhulabursary.repository.IStatusRepository;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Component
public class UniversityFundApplicationMapper implements RowMapper<UniversityFundApplication> {
    private final IStatusRepository statusRepository;

    @Override
    public UniversityFundApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
        UniversityFundApplication universityFundApplication = new UniversityFundApplication();
        if (rowNum > 0) {
            universityFundApplication.setId(rs.getLong("ApplicationID"));
            universityFundApplication.setFundingYear(rs.getDate("FundingYear").toLocalDate());
            universityFundApplication.setComment(rs.getString("Comment"));

            long statusId = rs.getLong("StatusID");
            Status status = statusRepository.findById(statusId)
                    .orElseThrow(() -> new StatusNotFoundException(statusId));
            universityFundApplication.setStatus(status);
        }
        return universityFundApplication;
    }
}
