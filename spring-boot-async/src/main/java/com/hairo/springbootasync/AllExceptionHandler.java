package com.hairo.springbootasync;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.reflect.UndeclaredThrowableException;


/**
 * @author ： Hairo
 * @date : 2020/5/26 10:55
 */
@ControllerAdvice
@Slf4j
public class AllExceptionHandler {



    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void exceptionHandler(MethodArgumentNotValidException e) {
        System.err.println("MethodArgumentNotValidException");
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e) {
        System.err.println("Exception");
    }

    @ResponseBody
    @ExceptionHandler(UndeclaredThrowableException.class)
    public void exceptionHandler(UndeclaredThrowableException e) {
        System.err.println("UndeclaredThrowableException");
    }

}
