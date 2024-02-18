package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityAndApplicationDTO;
import co.za.ukukhulabursary.ukukhulabursary.mapper.UniversityMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.repository.IUniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UniversityRepository implements IUniversityRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UniversityMapper universityMapper;

    @Override
    public List<University> findAll() {
        String sql = "SELECT * FROM [dbo].[University]";
        return jdbcTemplate.query(sql, universityMapper);
    }

    @Override
    public List<University> findAllByStatusId(long statusId) {
        String sql = "SELECT * FROM [dbo].[udfGetUniversityByStatus](?)";
        return jdbcTemplate.query(sql, universityMapper, statusId);
    }

    @Override
    public Optional<University> findById(long id) {
        String sql = "SELECT * FROM [dbo].[University] WHERE [UniversityID] = ?";
        List<University> universities = jdbcTemplate.query(sql, universityMapper, id);

        if (!universities.isEmpty())
            return Optional.of(universities.getFirst());
        return Optional.empty();
    }

    @Override
    public void save(UniversityAndApplicationDTO universityApplication) {
        String sql = "EXEC [dbo].[uspCreateUniversityAndApplication] " +
                     "@Name = ?, @ProvinceID = ?, @Comment = ?, @StatusID = ?";
        Object[] args = new Object[] {
                universityApplication.getName(),
                universityApplication.getProvinceId(),
                universityApplication.getComment(),
                universityApplication.getStatusId()
        };
        jdbcTemplate.update(sql, args);
    }
}
