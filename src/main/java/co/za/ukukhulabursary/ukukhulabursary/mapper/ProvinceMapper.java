package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceMapper implements RowMapper<Province> {
    @Override
    public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
        Province province = new Province();
        if (rowNum > 0) {
            province.setId(rs.getLong("ProvinceID"));
            province.setName(rs.getString("ProvinceName"));
        }
        return province;
    }
}
