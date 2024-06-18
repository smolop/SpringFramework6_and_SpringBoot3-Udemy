package com.sebas.curso.springboot.error.springboot_error.exceptions;

import com.sebas.curso.springboot.error.springboot_error.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception exception) {

        Error error = Error.builder()
                .message(exception.getMessage())
                .error("Division By Zero Error")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .date(new Date())
                .build();

//        return ResponseEntity
//                .internalServerError()
//                .body(error);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(NumberFormatException numberFormatException) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("Error", "Number Format Exception");
        responseMap.put("Message", numberFormatException.getMessage());
        responseMap.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseMap.put("Timestamp", new Date());

        return responseMap;
    }

    @ExceptionHandler({NullPointerException.class,
            HttpMessageNotWritableException.class,
            UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception userException) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("Error", "Not Found Exception");
        responseMap.put("Message", userException.getMessage());
        responseMap.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseMap.put("Timestamp", new Date());

        return responseMap;
    }

    @ExceptionHandler({NoHandlerFoundException.class, NoResourceFoundException.class, HttpClientErrorException.NotFound.class})
    public ResponseEntity<Error> notFoundException(Exception notFoundException) {

        Error error = new Error();
        error.setError("API REST Not Found.");
        error.setMessage(notFoundException.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setDate(new Date());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

}
