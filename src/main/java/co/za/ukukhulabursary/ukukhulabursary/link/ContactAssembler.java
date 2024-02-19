package co.za.ukukhulabursary.ukukhulabursary.link;

import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ContactAssembler implements RepresentationModelAssembler<ContactDetails, EntityModel<ContactDetails>> {

    @Override
    public EntityModel<ContactDetails> toModel(ContactDetails contact) {
        return EntityModel.of(contact);
    }
}
