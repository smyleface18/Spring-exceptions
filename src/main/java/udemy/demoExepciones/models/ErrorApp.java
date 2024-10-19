package udemy.demoExepciones.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorApp {

    private String messege;
    private String error;
    private int status;
    private Date date;


}
