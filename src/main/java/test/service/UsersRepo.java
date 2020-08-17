package test.service;

import org.springframework.data.repository.CrudRepository;
import test.Model.User;

public interface UsersRepo extends CrudRepository<User, Integer> {
}
