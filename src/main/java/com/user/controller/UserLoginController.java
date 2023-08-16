package com.user.controller;

import com.user.common.APIResponse;
import com.user.dto.LoginRequestDto;
import com.user.dto.SignupRequestDto;
import com.user.service.UserLoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserLoginController {

  private final UserLoginService userLoginService;

    public UserLoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping("/signup")
public ResponseEntity<APIResponse>signup(@RequestBody SignupRequestDto signupRequestDto){

      APIResponse apiResponse=userLoginService.signup(signupRequestDto);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }



    @PostMapping("/login")
    public ResponseEntity<APIResponse>login(@RequestBody LoginRequestDto loginRequestDto){

        APIResponse apiResponse=userLoginService.login(loginRequestDto);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }



    //DELETE
    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        userLoginService.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
