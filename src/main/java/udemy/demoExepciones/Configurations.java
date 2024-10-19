package udemy.demoExepciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import udemy.demoExepciones.models.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Configurations {

    @Bean
    public List<User> list(){

        return new ArrayList<User>(Arrays.asList(
            new User (1L,"pepe","Gonzalez"),
            new User (2L, "Maria","Pedraza"),
            new User (3L, "Juan","Pedraza"),
            new User (4L,"Andres","Mena"),
            new User (5L, "Jose","Ramirez"),
            new User (6L, "Daniela","Hernandez")
        ));
    }
}
