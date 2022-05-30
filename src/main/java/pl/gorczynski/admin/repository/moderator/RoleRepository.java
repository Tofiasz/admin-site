package pl.gorczynski.admin.repository.moderator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gorczynski.admin.model.moderator.Role;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    List<Role> findAll();
}
