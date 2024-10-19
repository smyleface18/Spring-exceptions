package udemy.demoExepciones.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.demoExepciones.exceptions.UserNotFoundException;
import udemy.demoExepciones.models.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;


    public UserServiceImpl(List<User> users) {
        this.users = users;

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return  users.stream()
                .filter( user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));
    }
}
