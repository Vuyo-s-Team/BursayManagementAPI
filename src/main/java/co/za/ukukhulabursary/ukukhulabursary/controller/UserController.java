package co.za.ukukhulabursary.ukukhulabursary.controller;

import co.za.ukukhulabursary.ukukhulabursary.link.ContactAssembler;
import co.za.ukukhulabursary.ukukhulabursary.model.Contact;
import co.za.ukukhulabursary.ukukhulabursary.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {
    private final IUserService userService;
    private final ContactAssembler contactAssembler;
    @GetMapping("/contact")
    public CollectionModel<EntityModel<Contact>> allContacts(){
        List<EntityModel<Contact>> contacts = userService.retrieveAllUserContacts().stream().map(contactAssembler::toModel).toList();
        return CollectionModel.of(contacts);
    }
}
