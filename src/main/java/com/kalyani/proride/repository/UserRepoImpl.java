package com.kalyani.proride.repository;

import com.kalyani.proride.model.User;
import com.kalyani.proride.repository.interfaces.UserRepo;
import com.kalyani.proride.utility.PersistenceUtility;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepoImpl implements UserRepo {

    private final EntityManager entityManager =  PersistenceUtility.getEntityManager();

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
    @Transactional
    public Optional<User> findByID(long userId) {
        return Optional.of(entityManager.find(User.class, userId));
    }

    @Override
    @Transactional
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
    public void deactivateUser(User user) {
        user.setIsActive(false);
        this.update(user);
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
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void rollback(EntityTransaction entityTransaction) {
        if ( entityTransaction!= null && entityTransaction.isActive()) {
            entityTransaction.rollback();
        }
    }

    /*@Override
    public void deleteByID(long userId) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query deleteByIdQuery = entityManager.createQuery("DELETE FROM User u WHERE u.userId = :userId");
            deleteByIdQuery.setParameter("userId",userId);
            deleteByIdQuery.executeUpdate();
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }*/
}
