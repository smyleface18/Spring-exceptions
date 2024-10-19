package udemy.demoExepciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import udemy.demoExepciones.exceptions.UserNotFoundException;
import udemy.demoExepciones.models.domain.User;
import udemy.demoExepciones.services.UserService;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/{a}")
    public String index(@PathVariable Long a){

        int number = Integer.parseInt("3d");
        return "ok 200";
    }

    @GetMapping("/user/{i}")
    public User getUser(@PathVariable(name = "i") Long idUser){
        return userService.findById(idUser);
    }
}
