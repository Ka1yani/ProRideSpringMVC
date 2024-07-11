package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import model.User;
import repository.interfaces.UserRepo;
import utility.PersistenceUtility;

import java.util.List;
import java.util.Optional;

public class UserRepoImpl implements UserRepo {

    private final EntityManager entityManager = PersistenceUtility.getEntityManager();

    @Override
    public void save(User user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
        } catch (Exception e){
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Optional<User> findByID(long userId) {
        return Optional.of(entityManager.find(User.class, userId));
    }

    @Override
    public User findByPhoneNo(String phoneNo) {
        TypedQuery<User> findByPhoneNoQuery = entityManager.createQuery("SELECT u FROM User u WHERE u.phoneNumber = :phoneNo", User.class);
        findByPhoneNoQuery.setParameter("phoneNo", phoneNo);
        return findByPhoneNoQuery.getSingleResult();
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> findAllQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
        return findAllQuery.getResultList();
    }

    @Override
    public void deleteByID(long userId) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.remove(userId);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(User user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.remove(entityManager.contains(user) ? user :entityManager.merge(user));
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<User> findByName(String name) {
        TypedQuery<User> findByNameQuery = entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class);
        findByNameQuery.setParameter("name", name);
        return findByNameQuery.getResultList();
    }

    @Override
    public boolean existsByPhoneNo(String phoneNo) {
        TypedQuery<Long> existsByPhoneNoQuery = entityManager.createQuery("select count(u) from User u where u.phoneNumber = :phoneNo", Long.class);
        existsByPhoneNoQuery.setParameter("phoneNo", phoneNo);
        return existsByPhoneNoQuery.getSingleResult() > 0;
    }

    @Override
    public boolean updateEmailById(int userId, String email) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            TypedQuery<User> updateEmailByIdQuery = entityManager.createQuery("UPDATE User u set u.email = :email where u.phoneNumber =:userId", User.class);
            updateEmailByIdQuery.setParameter("email", email);
            updateEmailByIdQuery.setParameter("userId", userId);
            int rows = updateEmailByIdQuery.executeUpdate();
            entityTransaction.commit();
            return rows > 0;
        } catch(RuntimeException e) {
            this.rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    public void update(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    private void rollback(EntityTransaction entityTransaction) {
        if ( entityTransaction!= null && entityTransaction.isActive()) {
            entityTransaction.rollback();
        }
    }
}
