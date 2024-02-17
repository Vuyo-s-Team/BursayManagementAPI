package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.exception.ProvinceNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.UniversityFundApplicationNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityFundApplication;
import co.za.ukukhulabursary.ukukhulabursary.repository.IProvinceRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.IUniversityFundApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@AllArgsConstructor
public class UniversityMapper implements RowMapper<University> {

    private final IProvinceRepository provinceRepository;
    private final IUniversityFundApplicationRepository universityFundApplicationRepository;

    @Override
    public University mapRow(ResultSet rs, int rowNum) throws SQLException {
        University university = new University();

        if (rowNum > 0) {
            long universityId = rs.getLong("UniversityID");
            university.setId(universityId);
            university.setName(rs.getString("Name"));

            long provinceId = rs.getLong("ProvinceID");
            Province province = provinceRepository.findById(provinceId)
                            .orElseThrow(() -> new ProvinceNotFoundException(provinceId));
            university.setProvince(province);

            UniversityFundApplication universityFundApplication = universityFundApplicationRepository
                    .findByUniversityId(universityId)
                    .orElseThrow(() -> new UniversityFundApplicationNotFoundException(universityId));
            university.setUniversityFundApplication(universityFundApplication);
        }
        return university;
    }
}
