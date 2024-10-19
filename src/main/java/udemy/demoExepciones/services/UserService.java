package udemy.demoExepciones.services;


import udemy.demoExepciones.models.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
}
