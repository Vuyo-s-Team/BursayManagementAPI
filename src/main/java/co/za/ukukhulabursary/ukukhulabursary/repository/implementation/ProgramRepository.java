package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.ProgramMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Program;
import co.za.ukukhulabursary.ukukhulabursary.repository.IRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProgramRepository implements IRepository<Program> {
    private final JdbcTemplate jdbcTemplate;
    private final ProgramMapper programMapper;

    @Override
    public List<Program> findAll() {
        return null;
    }

    @Override
    public Optional<Program> findById(long id) {
        String sql = "SELECT * FROM [dbo].[Program] WHERE [ProgramID] = ?";
        List<Program> program= jdbcTemplate.query(sql, programMapper, id);
        if (!program.isEmpty()){
            return Optional.of(program.getFirst());
        }

        return Optional.empty();
    }
}
