package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.exception.UniversityNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.UserNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.*;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.RaceRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UniversityRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@AllArgsConstructor
public class StudentMapper implements RowMapper<Student> {
    private final UserRepository userRepository;
    private final UniversityRepository universityRepository;
    private  final Gender genderRepository;
    private  final RaceRepository raceRepository;
    @Override
    public Student mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
       Student student = new Student();
        if (rowNumber > -1) {
            student.setStudentID(resultSet.getLong("StudentID"));
            student.setIdNumber(resultSet.getString("IDNumber"));
            student.setBirthDate(resultSet.getDate("BirthDate"));
            student.setAge(resultSet.getShort("Age"));
            long userID = resultSet.getLong("UserID");
            User user =userRepository.findById(userID)
                    .orElseThrow(() -> new UserNotFoundException(userID));
            student.setUser(user);
            long raceID = resultSet.getLong("RaceID");
            Race race = raceRepository.findById(raceID)
                    .orElseThrow(() -> new UserNotFoundException(userID));
            student.setRace(race);
            long genderID = resultSet.getLong("GenderID");
            Gender gender = genderRepository.findById(genderID)
                    .orElseThrow(() -> new UserNotFoundException(userID));
            long universityID=resultSet.getLong("UniversityID");
            University university = universityRepository.findById(universityID)
                    .orElseThrow(() -> new UniversityNotFoundException(universityID));;
            student.setUniversity(university);


        }
        return student;
    }
}
