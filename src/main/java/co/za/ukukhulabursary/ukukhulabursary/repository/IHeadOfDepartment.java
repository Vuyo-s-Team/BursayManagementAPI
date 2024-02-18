package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.HeadOfDepartment;

import java.util.List;

public interface IHeadOfDepartment {
    public List<HeadOfDepartment> findAll();

    public  HeadOfDepartment findById(long id);

}
