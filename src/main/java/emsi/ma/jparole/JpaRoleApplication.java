package emsi.ma.jparole;

import emsi.ma.jparole.entities.Role;
import emsi.ma.jparole.entities.User;
import emsi.ma.jparole.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaRoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaRoleApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService ){
        return arg->{
          /*  User user = new User();
            user.setUsername("marouane");
            user.setPassword("123");
            userService.addUser(user);

            User user1 = new User();
            user1.setUsername("admin");
            user1.setPassword("123");
            userService.addUser(user1);



            Stream.of("STUDENT","ADMIN","USER")
                    .forEach(r->{
                        Role role= new Role();
                        role.setRoleName(r);
                        userService.addRole(role);
                    });
            userService.addRoleToUser("marouane","STUDENT");
            userService.addRoleToUser("marouane","USER");
            userService.addRoleToUser("admin","ADMIN");
            userService.addRoleToUser("admin","STUDENT");*/

            try {
                User user2 = userService.athentificate("marouane","123");
                System.out.println(user2.getId());
                System.out.println(user2.getUsername());
                System.out.println("Rols=>");
                user2.getRoles().forEach(r->{
                    System.out.println(r.toString());
                });
            }catch (Exception exception){
                exception.printStackTrace();
            }
        };
    }

}
