package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;



import co.za.ukukhulabursary.ukukhulabursary.mapper.RaceMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Race;
import co.za.ukukhulabursary.ukukhulabursary.repository.IRaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RaceRepository implements IRaceRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RaceMapper raceMapper;
    @Override
    public Optional<Race> findById(long id) {
        String sql = "SELECT * FROM [dbo].[Race] WHERE [RaceID] = ?";
        List<Race> raceList = jdbcTemplate.query(sql, raceMapper, id);
        if (!raceList.isEmpty())
            return Optional.of(raceList.getFirst());
        return Optional.empty();
    }

}
