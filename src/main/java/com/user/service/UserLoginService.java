package com.user.service;

import com.user.common.APIResponse;
import com.user.dto.LoginRequestDto;
import com.user.dto.SignupRequestDto;
import com.user.entity.User;
import com.user.repo.UserRepository;
import com.user.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;
    public APIResponse signup(SignupRequestDto signupRequestDto) {
        APIResponse apiResponse=new APIResponse();


        //dto to entity
        User userentity=new User();
        userentity.setUsername(signupRequestDto.getUsername());
        userentity.setGender(signupRequestDto.getGender());
        userentity.setPassword(signupRequestDto.getPassword());
        userentity.setGender(signupRequestDto.getGender());
        userentity.setIsActive(Boolean.TRUE);

        //store entity
        userentity= userRepository.save(userentity);

apiResponse.setData(userentity);
        return apiResponse;
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public APIResponse login(LoginRequestDto loginRequestDto) {
        APIResponse apiResponse=new APIResponse();
        //verify users exist with email and password
       User user= userRepository.findOneByEmailIgnoreCaseAndPassword(loginRequestDto.getEmail(),loginRequestDto.getPassword());

       //RESPONSE
        if (user==null){
            apiResponse.setData("user login failed");
            return apiResponse;
        }
        //generate jwt
       String token= jwtUtils.generateJwt(user);
        apiResponse.setData(token);

        return apiResponse;
    }
}
