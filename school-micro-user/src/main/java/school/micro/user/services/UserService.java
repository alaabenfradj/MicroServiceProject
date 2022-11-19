package school.micro.user.services;

import java.util.List;

import school.micro.user.models.Role;
import school.micro.user.models.User;

public interface UserService {

    User saveUser (User user,String role );
    Role saveRole (Role role);
    void assignRoleToUser (String userName,String roleName);
    User getUser (String username);
    List<User> getAllUsers();
    User getUserById (String id);
    
 }
