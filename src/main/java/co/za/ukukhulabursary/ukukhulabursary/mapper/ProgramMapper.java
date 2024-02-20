package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.Gender;
import co.za.ukukhulabursary.ukukhulabursary.model.Program;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProgramMapper implements RowMapper<Program> {
    @Override
    public Program mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Program program = new Program();
        if (rowNumber >-1){
            program.setProgramID(resultSet.getLong("ProgramID"));
            program.setProgramName(resultSet.getString("ProgramName"));

        }
        return program;
    }
}
