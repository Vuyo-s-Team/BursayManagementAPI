package co.za.ukukhulabursary.ukukhulabursary.link;

import co.za.ukukhulabursary.ukukhulabursary.controller.UserController;
import co.za.ukukhulabursary.ukukhulabursary.model.Contact;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ContactAssembler implements RepresentationModelAssembler<Contact, EntityModel<Contact>> {

    @Override
    public EntityModel<Contact> toModel(Contact contact) {
        return EntityModel.of(contact);
    }
}
