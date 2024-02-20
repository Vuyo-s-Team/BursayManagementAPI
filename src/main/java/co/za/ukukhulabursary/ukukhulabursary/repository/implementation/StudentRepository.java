package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.model.Student;
import co.za.ukukhulabursary.ukukhulabursary.repository.IRepository;

import java.util.List;
import java.util.Optional;

public class StudentRepository implements IRepository<Student> {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Optional<Student> findById(long id) {
        return Optional.empty();
    }


    public List<Student> ListOfFundedStudents() {
        return null;
    }


    public List<Student> ListOfStundentInTheirFinalYear() {
        return null;
    }
}
