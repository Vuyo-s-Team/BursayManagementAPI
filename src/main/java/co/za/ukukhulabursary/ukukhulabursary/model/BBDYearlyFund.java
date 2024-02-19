package co.za.ukukhulabursary.ukukhulabursary.model;

import lombok.Data;

import java.util.Date;

@Data
public class BBDYearlyFund {
    private long yearlyFundID;
    private  double totalAmount;
    private  double remainingAmount;
    private Date finacialYearStart;
    private  double studentFundCap;

}
