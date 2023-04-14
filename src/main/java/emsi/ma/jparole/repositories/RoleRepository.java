package emsi.ma.jparole.repositories;

import emsi.ma.jparole.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(String usrName);
}
