package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.UserMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.User;
import co.za.ukukhulabursary.ukukhulabursary.repository.IRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepository  implements IRepository<User> {
    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM [dbo].[User]";
        return jdbcTemplate.query(sql, userMapper);
    }

    @Override
    public Optional<User> findById(long id) {
        String sql = "SELECT * FROM [dbo].[University] WHERE [UserID] = ?";
        List<User> user = jdbcTemplate.query(sql, userMapper, id);

        if (!user.isEmpty()){
            return  Optional.of(user.getFirst());
        }

        return Optional.empty();
    }
}
