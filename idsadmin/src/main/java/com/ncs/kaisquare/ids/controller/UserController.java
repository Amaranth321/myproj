package com.ncs.kaisquare.ids.controller;

import com.ncs.kaisquare.ids.entity.User;
import com.ncs.kaisquare.ids.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    //private Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value="add a user!",notes = "username and password is required!")
    @ApiImplicitParam(dataType = "User" , name = "user" ,value = "user" ,required = true)
    @ApiResponse(response = String.class,code = 200,message = "success")
    @PostMapping(value = "/user")
    public String insertOne(@RequestBody User user){
        try {
            userService.insertOne(user);
            return "success";
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return String.format("error:%s",e.getMessage());
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
            e.printStackTrace();
        }
        return user;
    }


}
