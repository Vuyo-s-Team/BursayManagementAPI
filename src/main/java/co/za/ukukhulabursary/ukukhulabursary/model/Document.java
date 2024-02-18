package co.za.ukukhulabursary.ukukhulabursary.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Document {
   @Id
    private Long DocumentID;
    private String Transcript;
    private String IdentityDocument;
    private Integer ApplicationID;
    
}
