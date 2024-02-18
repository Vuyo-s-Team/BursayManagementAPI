package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.BBDYearlyFundMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.BBDYearlyFund;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class YearlyFundRepository {
    private  JdbcTemplate jdbcTemplate;
    private  BBDYearlyFundMapper mapper;

    public List<BBDYearlyFund> findAll() {
        String sql = "SELECT * FROM [dbo].[BBDYearlyFund]";
        return jdbcTemplate.query(sql,mapper );
    }


    public Optional<BBDYearlyFund> findById(long id) {
        String sql = "SELECT * FROM [dbo].[BBDYearlyFund] WHERE [YearlyFundID] = ?";
        List<BBDYearlyFund> yearlyFunds = jdbcTemplate.query(sql, mapper, id);

        if (!yearlyFunds.isEmpty()){
            return  Optional.of(yearlyFunds.getFirst());
        }

        return Optional.empty();
    }
}
