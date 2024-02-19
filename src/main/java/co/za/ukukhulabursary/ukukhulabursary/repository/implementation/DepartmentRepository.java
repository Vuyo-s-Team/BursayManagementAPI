package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.DepartmentMapper;
import co.za.ukukhulabursary.ukukhulabursary.mapper.ProvinceMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Department;
import co.za.ukukhulabursary.ukukhulabursary.repository.IDepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class DepartmentRepository implements IDepartmentRepository {
    private final JdbcTemplate jdbcTemplate;
    private final DepartmentMapper mapper;

    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM [dbo].[Department]";
        return jdbcTemplate.query(sql,mapper);
    }

    @Override
    public Optional<Department> findById(long id) {
        String sql = "SELECT * FROM [dbo].[Department] WHERE DepartmentID=?";
        List<Department> departments = jdbcTemplate.query(sql,mapper,id);
        if(!departments.isEmpty())
            return Optional.of(departments.getFirst());
        return Optional.empty();
    }
}
