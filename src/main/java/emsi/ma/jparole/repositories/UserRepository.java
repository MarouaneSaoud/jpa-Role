package emsi.ma.jparole.repositories;

import emsi.ma.jparole.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , String> {
    User findUserByUsername(String username);
}
