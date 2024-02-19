package co.za.ukukhulabursary.ukukhulabursary.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Document {
   @Id
    private Long documentID;
    private String transcript;
    private String identityDocument;
    private Integer applicationID;
    
}
