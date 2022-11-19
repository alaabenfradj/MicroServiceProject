package school.micro.user.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import school.micro.user.models.Role;

@Repository
public interface RoleRepo extends MongoRepository<Role,String> {

    Role findByName(String name);
}
