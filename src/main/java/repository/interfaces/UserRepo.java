package repository.interfaces;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {
    void save(User user);
    Optional<User> findByID(long userId);
    User findByPhoneNo(String phoneNo);
    List<User> findAll();
    void deleteByID(long userId);
    void delete(User user);
    List<User> findByName(String name);
    boolean existsByPhoneNo(String phoneNo);

    boolean updateEmailById(int userId, String email);

    void update(User user);

}
