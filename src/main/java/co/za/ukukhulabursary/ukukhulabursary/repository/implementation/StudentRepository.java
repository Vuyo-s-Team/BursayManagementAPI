package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.model.Student;
import co.za.ukukhulabursary.ukukhulabursary.repository.IStudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentRepository implements IStudentRepository {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Optional<Student> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Student> ListOfFundedStudents() {
        return null;
    }

    @Override
    public List<Student> ListOfStundentInTheirFinalYear() {
        return null;
    }
}
