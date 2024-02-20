package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.exception.UniversityFundApplicationNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.mapper.UniversityFundApplicationMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityFundApplication;
import co.za.ukukhulabursary.ukukhulabursary.repository.IRepository;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Data
@Repository
public class UniversityFundApplicationRepository implements IRepository<UniversityFundApplication> {

    private final JdbcTemplate jdbcTemplate;
    private final UniversityFundApplicationMapper mapper;


    public Optional<UniversityFundApplication> findByUniversityId(long universityId) {
        String sql = "SELECT * FROM [dbo].[UniversityFundApplication] WHERE [UniversityID] = ?";
        List<UniversityFundApplication> universityFundApplications = jdbcTemplate.query(sql, mapper, universityId);

        if (!universityFundApplications.isEmpty())
            return Optional.of(universityFundApplications.getFirst());
        return Optional.empty();
    }



    public Optional<UniversityFundApplication> updateUniversityApplicationStatus(long universityId, long statusId) {
        findByUniversityId(universityId)
                .orElseThrow(() -> new UniversityFundApplicationNotFoundException(universityId));

        String sql = "UPDATE [dbo].[UniversityFundApplication] SET [StatusID] = ? WHERE [UniversityID] = ?";

        int updateCount = jdbcTemplate.update(sql, statusId, universityId);
        return findByUniversityId(universityId);
    }

    @Override
    public List<UniversityFundApplication> findAll() {
        return null;
    }

    @Override
    public Optional<UniversityFundApplication> findById(long id) {
        return Optional.empty();
    }
}
