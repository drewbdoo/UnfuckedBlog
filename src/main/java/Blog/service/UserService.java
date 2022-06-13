package Blog.service;

import Blog.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser (User user);
    Optional<User> getUserById (Long id);
    void deleteUserById (Long id);
    List <User> getAllUsers ();
}