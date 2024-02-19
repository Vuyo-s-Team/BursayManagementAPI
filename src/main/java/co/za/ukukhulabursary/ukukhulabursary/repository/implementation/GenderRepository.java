package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.GenderMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Gender;
import co.za.ukukhulabursary.ukukhulabursary.repository.IGenderRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@AllArgsConstructor
public class GenderRepository implements IGenderRepository {
    private final JdbcTemplate jdbcTemplate;
    private final GenderMapper mapper;
    @Override
    public Optional<Gender> findById(long id) {
        String sql = "SELECT * FROM [dbo].[Gender] WHERE GenderID =?";

        List<Gender> genders = jdbcTemplate.query(sql,mapper,id);
        if(!genders.isEmpty())
            return Optional.of(genders.getFirst());
        return Optional.empty();
    }

    @Override
    public List<Gender> findAll() {
        String sql = "SELECT * FROM [dbo].[Gender]";
        return jdbcTemplate.query(sql,mapper);
    }
}
