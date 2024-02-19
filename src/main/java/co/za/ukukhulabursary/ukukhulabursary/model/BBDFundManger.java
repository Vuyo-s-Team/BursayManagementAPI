package co.za.ukukhulabursary.ukukhulabursary.model;

import lombok.Data;

@Data
public class BBDFundManger {
    private long fundMangerID;
    private User user;
    private  BBDYearlyFund yearlyFund;

}
