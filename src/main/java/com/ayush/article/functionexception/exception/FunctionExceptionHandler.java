package com.ayush.article.functionexception.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Map;

@RestControllerAdvice
public class FunctionExceptionHandler {

    @ExceptionHandler({SQLException.class})
    public Map<String,String> handleSQLException( SQLException exception){
        return Map.of(
                "error",exception.getLocalizedMessage().split("\n")[0]
        );
    }
}
