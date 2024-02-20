package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.exception.ProvinceNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityFundApplication;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.ProvinceRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UniversityFundApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UniversityMapper implements RowMapper<University> {

    private final ProvinceRepository provinceRepository;
    private final UniversityFundApplicationRepository universityFundApplicationRepository;

    @Override
    public University mapRow(ResultSet rs, int rowNum) throws SQLException {
        University university = new University();

        if (rowNum > -1) {
            long universityId = rs.getLong("UniversityID");
            university.setId(universityId);
            university.setName(rs.getString("Name"));

            long provinceId = rs.getLong("ProvinceID");
            Province province = provinceRepository.findById(provinceId)
                            .orElseThrow(() -> new ProvinceNotFoundException(provinceId));
            university.setProvince(province);

            Optional<UniversityFundApplication> universityFundApplication = universityFundApplicationRepository
                    .findByUniversityId(universityId);

            universityFundApplication.ifPresent(university::setUniversityFundApplication);
        }
        return university;
    }
}
