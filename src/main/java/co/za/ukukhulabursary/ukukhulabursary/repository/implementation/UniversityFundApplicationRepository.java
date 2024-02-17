package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.UniversityFundApplicationMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityFundApplication;
import co.za.ukukhulabursary.ukukhulabursary.repository.IUniversityFundApplicationRepository;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Data
@Repository
public class UniversityFundApplicationRepository implements IUniversityFundApplicationRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UniversityFundApplicationMapper mapper;

    @Override
    public Optional<UniversityFundApplication> findByUniversityId(long universityId) {
        String sql = "SELECT * FROM [dbo].[UniversityFundApplication] WHERE [UniversityID] = ?";
        List<UniversityFundApplication> universityFundApplications = jdbcTemplate.query(sql, mapper, universityId);

        if (!universityFundApplications.isEmpty())
            return Optional.of(universityFundApplications.getFirst());
        return Optional.empty();
    }
}
