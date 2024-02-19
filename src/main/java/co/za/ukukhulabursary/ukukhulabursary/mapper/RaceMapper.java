package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.Race;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RaceMapper  implements RowMapper<Race> {

    @Override
    public Race mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Race race = new Race();
        if (rowNumber >-1){
            race.setRaceID(resultSet.getLong("RaceID"));
            race.setName(resultSet.getString("Name"));
        }
        return race;
    }
}
