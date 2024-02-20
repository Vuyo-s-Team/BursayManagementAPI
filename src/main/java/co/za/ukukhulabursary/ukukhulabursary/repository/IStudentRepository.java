package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository {
    public List<Student> findAll();
    public Optional<Student> findById(long id);
    public Optional<List<Student>> ListOfFundedStudents();
    public List<Student> ListOfStundentInTheirFinalYear();
}
