package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.Contact;

import java.util.List;

public interface IContact {
    public List<Contact> findAll();
    public Contact findById();
}
