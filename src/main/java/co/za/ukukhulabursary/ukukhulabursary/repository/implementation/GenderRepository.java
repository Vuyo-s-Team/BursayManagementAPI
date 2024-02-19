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
    private final GenderMapper genderMapper;
    public Optional<Gender> findById(long id) {
        String sql = "SELECT * FROM [dbo].[Gender] WHERE [GenderID] = ?";
        List<Gender> genderList = jdbcTemplate.query(sql, genderMapper, id);
        if (!genderList.isEmpty())
            return Optional.of(genderList.getFirst());
        return Optional.empty();
    }
}
