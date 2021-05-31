package com.userOrange.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObejctNotFoundExecption extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObejctNotFoundExecption(String msg){
        super(msg);
    }

    public ObejctNotFoundExecption(String msg, Throwable cause){
        super(msg, cause);
    }
}
