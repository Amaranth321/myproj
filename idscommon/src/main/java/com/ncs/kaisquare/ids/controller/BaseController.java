package com.ncs.kaisquare.ids.controller;

import com.ncs.kaisquare.ids.auth.JwtConfig;
import com.ncs.kaisquare.ids.auth.JwtParser;
import com.ncs.kaisquare.ids.exceptions.IdsException;
import com.ncs.kaisquare.ids.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class BaseController {

    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private JwtParser jwtParser;

    protected String getCurrentUser(HttpServletRequest request){
        String token = request.getHeader(jwtConfig.getHeader()).replace(jwtConfig.getPrefix(),"");
        return jwtParser.getValueAsString(token,"sub");
    }

    @ExceptionHandler(value = IdsException.class)
    public ApiResponse exception(IdsException exception){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(exception.getCode());
        apiResponse.setMessage(exception.getMessage());
        return apiResponse;
    }






}
