package com.ncs.kaisquare.ids.controller;

import com.ncs.kaisquare.ids.auth.JwtParser;
import com.ncs.kaisquare.ids.entity.User;
import com.ncs.kaisquare.ids.exceptions.ApiException;
import com.ncs.kaisquare.ids.exceptions.IdsException;
import com.ncs.kaisquare.ids.exceptions.UnsupportedTypeException;
//import com.ncs.kaisquare.ids.response.ApiResponse;
import com.ncs.kaisquare.ids.response.ObjectResponse;
import com.ncs.kaisquare.ids.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class UserController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value="add a user!",notes = "username and password is required!")
    @ApiImplicitParam(dataType = "User" , name = "user" ,value = "user" ,required = true)
    @ApiResponse(response = String.class,code = 200,message = "success")
    @PostMapping(value = "/user")
    public String insertOne(@RequestBody User user){
        try {
            user.encriptPassword();
            user.preSave();
            logger.info("password: "+user.getPassword());
            userService.insertOne(user);
            return "success";
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return String.format("error:"+e.getMessage());
        }
    }

    @ApiOperation(value = "find a user by id",notes = "id is required")
    @ApiImplicitParam(dataType = "String" ,name="id", value = "id",required = true)
    @ApiResponse(code = 200,message = "success", response = User.class)
    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") String id){
        User user = null;
        try {
            user = userService.findById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return user;
    }

    @GetMapping("/login")
    public String login() throws IdsException{
        if(1>0){
            throw new ApiException("this is a exception test!!");
        }else{
            return "11";
        }

    }

    @GetMapping("/user/findbyname/{username}")
    public User findByUsername(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }

    @GetMapping("/user/token")
    public String tokenTest(HttpServletRequest request){
        return getCurrentUser(request);
    }

}
