package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.ProvinceMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import co.za.ukukhulabursary.ukukhulabursary.repository.IProvinceRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProvinceRepository implements IProvinceRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProvinceMapper mapper;

    @Override
    public List<Province> findAll() {
        String sql = "SELECT * FROM [dbo].[Province]";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Optional<Province> findById(long id) {
        String sql = "SELECT * FROM [dbo].[Province] WHERE [ProvinceID] = ?";
        List<Province> provinces = jdbcTemplate.query(sql, mapper, id);
        if (!provinces.isEmpty())
            return Optional.of(provinces.getFirst());
        return Optional.empty();
    }
}
