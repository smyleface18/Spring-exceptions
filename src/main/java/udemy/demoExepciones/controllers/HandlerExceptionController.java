package udemy.demoExepciones.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import udemy.demoExepciones.exceptions.UserNotFoundException;
import udemy.demoExepciones.models.ErrorApp;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptionController {


    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> divisionByZero(Exception ex){ //signo de pregunta
        // es para decir que puede retornar cual quier tipo de dato

        ErrorApp error = new ErrorApp();
        error.setDate( new Date());
        error.setError("Error no se puede dividir por cero");
        error.setMessege(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        //return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorApp> noHandlerFoundException(NoHandlerFoundException ex){
        ErrorApp error = new ErrorApp();
        error.setDate( new Date());
        error.setError("No Found");
        error.setMessege(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> numberFormatException(Exception ex){
        Map<String,Object> error = new LinkedHashMap<>();
        error.put("date", new Date() );
        error.put("error", "numero invalido o incorrecto, no tiene formato de digito" );
        error.put("message", ex.getMessage() );
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR);

        return error;
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorApp> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorApp error = new ErrorApp();
        error.setDate(new Date());
        error.setError("Usuario no encontrado");
        error.setMessege(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
