package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.StudentMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Student;
import co.za.ukukhulabursary.ukukhulabursary.repository.IStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class StudentRepository implements IStudentRepository {
    private final JdbcTemplate jdbcTemplate;
    private final StudentMapper studentMapper;
    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM [dbo].[Student]";
        return jdbcTemplate.query(sql, studentMapper);
    }

    @Override
    public Optional<Student> findById(long id) {
        String sql = "SELECT * FROM [dbo].[Student] WHERE [StudentID] = ?";
        List<Student> students = jdbcTemplate.query(sql, studentMapper, id);

        if (!students.isEmpty()){
            return  Optional.of(students.getFirst());
        }

        return Optional.empty();
    }

    @Override
    public Optional<List<Student>> ListOfFundedStudents() {
        String sql ="SELECT * FROM [dbo].[Student]\n" +
                "INNER JOIN [StudentApplication] ON [Student].StudentID =[StudentApplication].StudentID\n" +
                "WHERE [StudentApplication].StatusID =1";
        return jdbcTemplate.query(sql, studentMapper);




    }

    @Override
    public List<Student> ListOfStundentInTheirFinalYear() {
        return null;
    }
}
