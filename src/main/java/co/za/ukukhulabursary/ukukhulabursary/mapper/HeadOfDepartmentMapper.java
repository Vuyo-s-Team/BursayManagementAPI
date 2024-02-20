package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.*;
import co.za.ukukhulabursary.ukukhulabursary.repository.IUniversityRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
@AllArgsConstructor
public class HeadOfDepartmentMapper implements RowMapper<HeadOfDepartment> {
    IUniversityRepository universityRepository;
    IDepartmentRepository departmentRepository;
    IUserRepository userRepository;
 @Override
public HeadOfDepartment mapRow(ResultSet rs, int rowNum) throws SQLException {
        HeadOfDepartment headOfDepartment = new HeadOfDepartment();
        if(rowNum > -1){
            headOfDepartment.setId( rs.getLong("HeadOfDepartmentID"));

            Optional<University> university = universityRepository.findById(rs.getLong("UniversityID"))
                    ;
            university.ifPresent(headOfDepartment::setUniversity);

            Optional<Department> department = departmentRepository.findById(rs.getLong("DepartmentID"));
            department.ifPresent(headOfDepartment::setDepartment);

            Optional<User> user = userRepository.findById(rs.getLong("UserID"));
            user.ifPresent(headOfDepartment::setUser);
        }
        return headOfDepartment;
    }
}
