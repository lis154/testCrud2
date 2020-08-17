package test.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import test.Model.User;

@Component
public interface UsersRepo extends CrudRepository<User, Integer> {
}
