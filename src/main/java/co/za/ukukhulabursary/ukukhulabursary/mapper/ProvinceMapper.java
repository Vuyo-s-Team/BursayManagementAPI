package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProvinceMapper implements RowMapper<Province> {
    @Override
    public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
        Province province = new Province();
        if (rowNum > -1) {
            province.setId(rs.getLong("ProvinceID"));
            province.setName(rs.getString("Name"));
        }
        return province;
    }
}
