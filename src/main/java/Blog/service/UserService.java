package Blog.service;

import Blog.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUser (User user);
    Optional<User> findbyUsername(String username);
    void deleteUserById (Long id);
    List <User> getAllUsers ();
}