package co.za.ukukhulabursary.ukukhulabursary.dto;

import lombok.Data;

@Data
public class UniversityAndApplicationDTO {
    private String name;
    private long provinceId;
    private String comment;
    private long statusId;
}
