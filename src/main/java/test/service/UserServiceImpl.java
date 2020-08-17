package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import test.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl {
   // final
   // UsersRepo repo;

    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<User> listAll() throws DataAccessException {
        Query query = getEntityManager().createQuery("select c from User c");
        List<User> resultList = query.getResultList();
        return resultList;
    }
    @Transactional
    public User get(Long carId) throws DataAccessException {
        return getEntityManager().find(User.class, carId);
    }

    @Transactional
    public int count() throws DataAccessException {
        Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM User " );
        int rez = query.getFirstResult();
        return rez;
    }

    @Transactional
    public void save(User user) throws DataAccessException {
        getEntityManager().persist(user);
    }

    @Transactional
    public void delete(User user) throws DataAccessException {
        getEntityManager().remove(user);
    }





//    @Autowired
//    public UserServiceImpl(UsersRepo repo, EntityManager entityManager) {
//        this.repo = repo;
//        this.entityManager = entityManager;
//    }
//
//    public void save(User customer) {
//
//        repo.save(customer);
//    }
//
//    public List<User> listAll() {
//        return (List<User>) repo.findAll();
//    }
//
//    public User get(Long id) {
//        return repo.findById(Math.toIntExact(id)).get();
//    }
//
//    public void delete(User user) {
//        repo.delete(user);
//    }
//
//    public int count() {
//        return (int) repo.count();
//    }
}
