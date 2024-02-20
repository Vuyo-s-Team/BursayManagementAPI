package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.StatusMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Status;
import co.za.ukukhulabursary.ukukhulabursary.repository.IRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.IStatusRepository;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Data
@Repository
public class StatusRepository implements IRepository<Status> {

    private final JdbcTemplate jdbcTemplate;
    private final StatusMapper statusMapper;

    @Override
    public List<Status> findAll() {
        String sql = "SELECT * FROM [dbo].[Status]";
        return jdbcTemplate.query(sql, statusMapper);
    }

    @Override
    public Optional<Status> findById(long id) {
        String sql = "SELECT * FROM [dbo].[Status] WHERE [StatusID] = ?";
        List<Status> statusList = jdbcTemplate.query(sql, statusMapper, id);
        if (!statusList.isEmpty())
            return Optional.of(statusList.getFirst());
        return Optional.empty();
    }
}
