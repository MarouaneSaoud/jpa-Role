package emsi.ma.jparole.service;

import emsi.ma.jparole.entities.Role;
import emsi.ma.jparole.entities.User;

public interface UserService {
    User addUser (User user);
    Role addRole (Role role);

    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName , String roleName);
    User athentificate(String userName , String password);

}
