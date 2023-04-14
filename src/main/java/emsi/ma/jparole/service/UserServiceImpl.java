package emsi.ma.jparole.service;

import emsi.ma.jparole.entities.Role;
import emsi.ma.jparole.entities.User;
import emsi.ma.jparole.repositories.RoleRepository;
import emsi.ma.jparole.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;



    @Override
    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = this.findUserByUserName(userName);
        Role role = this.findRoleByRoleName(roleName);
        if(user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepository.save(user);

    }

    @Override
    public User athentificate(String userName, String password) {
        User user = userRepository.findUserByUsername(userName);
        if(user==null)
            throw  new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password))
            return user ;
        throw  new RuntimeException("Bad credentials");
    }
}
