package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.BBDYearlyFund;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BBDYearlyFundMapper implements RowMapper<BBDYearlyFund> {

    @Override
    public  BBDYearlyFund mapRow(ResultSet resultSet , int rowNumber)throws SQLException{
        BBDYearlyFund bbdYearlyFund = new BBDYearlyFund();
        if(rowNumber>0){
            bbdYearlyFund.setYearlyFundID(resultSet.getLong("YearlyFundID"));
            bbdYearlyFund.setTotalAmount(resultSet.getDouble("TotalAmount"));
            bbdYearlyFund.setRemainingAmount(resultSet.getDouble("tRemainingAmount"));
            bbdYearlyFund.setFinacialYearStart(resultSet.getDate("FinancialYearStart"));
            bbdYearlyFund.setStudentFundCap(resultSet.getDouble("StudentFundCap"));
        }


        return  bbdYearlyFund;

    }
}
