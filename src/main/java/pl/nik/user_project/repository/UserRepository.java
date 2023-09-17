package pl.nik.user_project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.nik.user_project.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
