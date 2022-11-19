package school.micro.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import school.micro.user.models.Role;
import school.micro.user.models.User;
import school.micro.user.repos.RoleRepo;
import school.micro.user.services.UserService;

@SpringBootApplication
public class ReserveveloMicroUserApplication {
    @Autowired
    RoleRepo roleRepo;

    public static void main(String[] args) {
        SpringApplication.run(ReserveveloMicroUserApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            if (roleRepo.findByName("ROLE_USER") == null) {
                userService.saveRole(new Role(null, "ROLE_USER"));
            }
            if (roleRepo.findByName("ROLE_ADMIN") == null) {
                userService.saveRole(new Role(null, "ROLE_ADMIN"));
            }
            if (roleRepo.findByName("ROLE_TEACHER") == null) {
                userService.saveRole(new Role(null, "ROLE_TEACHER"));
            }
            if (roleRepo.findByName("ROLE_STUDENT") == null) {
                userService.saveRole(new Role(null, "ROLE_STUDENT"));
            }
            if (roleRepo.findByName("ROLE_PARENT") == null) {
                userService.saveRole(new Role(null, "ROLE_PARENT"));
            }

//         userService.saveUser(new User(null,"admin","admin","admin","admin@gmail.com","admin",1,new ArrayList<>()));
//         userService.saveUser(new User(null,"user","user","user","user@gmail.com","user",2,new ArrayList<>()));
//         userService.assignRoleToUser("admin","ROLE_ADMIN");
//         userService.assignRoleToUser("user","ROLE_USER");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}