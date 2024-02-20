package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityMoneySpentDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UniversityMoneySpentMapper  implements RowMapper<UniversityMoneySpentDTO> {

    @Override
    public UniversityMoneySpentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UniversityMoneySpentDTO university = new UniversityMoneySpentDTO();
        university.setName(rs.getString("Name"));
        university.setMoneySpent(rs.getDouble("Money Spent"));
        return university;
    }
}
