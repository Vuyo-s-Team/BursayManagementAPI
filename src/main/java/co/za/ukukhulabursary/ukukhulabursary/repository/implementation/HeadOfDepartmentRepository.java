package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.HeadOfDepartmentMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.HeadOfDepartment;
import co.za.ukukhulabursary.ukukhulabursary.repository.IRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HeadOfDepartmentRepository implements IRepository<HeadOfDepartment> {
    private final JdbcTemplate jdbcTemplate;
    private final HeadOfDepartmentMapper mapper;
    @Override
    public List<HeadOfDepartment> findAll() {
        String sql = "SELECT * FROM [dbo].[HeadOfDepartment]";
        return jdbcTemplate.query(sql,mapper);
    }

    @Override
    public Optional<HeadOfDepartment> findById(long id) {
        String sql = "SELECT * FROM [dbo].[HeadOfDepartment]";
        List<HeadOfDepartment> headOfDepartments = jdbcTemplate.query(sql, mapper);
        if(!headOfDepartments.isEmpty())
            return Optional.of(headOfDepartments.getFirst());
        return Optional.empty();
    }
}
