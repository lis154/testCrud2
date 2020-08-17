package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import test.Model.User;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl {
    final
    UsersRepo repo;

    @Autowired
    public UserServiceImpl(UsersRepo repo) {
        this.repo = repo;
    }

    public void save(User customer) {
        repo.save(customer);
    }

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public User get(Long id) {
        return repo.findById(Math.toIntExact(id)).get();
    }

    public void delete(User user) {
        repo.delete(user);
    }

    public int count() {
        return (int) repo.count();
    }
}
