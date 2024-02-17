package co.za.ukukhulabursary.ukukhulabursary.repository.impl;

import co.za.ukukhulabursary.ukukhulabursary.mapper.UniversityMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.repository.IUniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
