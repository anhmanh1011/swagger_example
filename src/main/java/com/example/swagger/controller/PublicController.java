package com.example.swagger.controller;

import com.example.swagger.dto.UserInfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.swagger.controller.BaseController.EXTERNAL;
import static com.example.swagger.controller.BaseController.PUBLIC;

@Api(tags = "Public")
@RequestMapping(PUBLIC + "/users")
@RestController
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "success"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
}
)
public class PublicController {

    @ApiOperation("Get User Info")
    @GetMapping(value = "/{id}", produces = {"application/json"})
    @ApiResponses(value = {
            @ApiResponse(code = 456, message = "user not found"),
    }
    )
    public UserInfoResponse getUserInfo(@PathVariable String id) {
        if(!id.equals("456")){
            // throw new ex ( error code = 123 , messages = user not fount"
            return null;
        }
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setEmail("email@gmail.com");
        userInfoResponse.setCusToCd("047C123131");
        userInfoResponse.setFullName("dao dad");
        userInfoResponse.setId(id);
        userInfoResponse.setMobile("0123456");
        return userInfoResponse;
    }
}
