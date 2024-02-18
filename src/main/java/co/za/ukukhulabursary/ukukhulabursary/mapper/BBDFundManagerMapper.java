package co.za.ukukhulabursary.ukukhulabursary.mapper;


import co.za.ukukhulabursary.ukukhulabursary.exception.UserNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.YearlyFundTableNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.BBDFundManger;
import co.za.ukukhulabursary.ukukhulabursary.model.BBDYearlyFund;
import co.za.ukukhulabursary.ukukhulabursary.model.User;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UserRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.YearlyFundRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@AllArgsConstructor
public class BBDFundManagerMapper implements RowMapper<BBDFundManger> {
    private final YearlyFundRepository yearlyFundRepository;
    private final UserRepository userRepository;
    @Override
    public BBDFundManger mapRow(ResultSet resultSet, int rowNumber) throws SQLException {

        BBDFundManger fundManger = new BBDFundManger();
        if (rowNumber>0){
            fundManger.setFundMangerID(resultSet.getLong("FundManagerID"));
            long yealyFundID = resultSet.getLong("YearlyFundID");
            BBDYearlyFund yearlyFund = yearlyFundRepository.findById(yealyFundID)
                    .orElseThrow(() -> new YearlyFundTableNotFoundException(yealyFundID));
            fundManger.setYearlyFund(yearlyFund);
            long userID = resultSet.getLong("UserID");
            User user =userRepository.findById(userID)
                    .orElseThrow(() -> new UserNotFoundException(userID));
            fundManger.setUser(user);

        }

        return fundManger;
    }
}
