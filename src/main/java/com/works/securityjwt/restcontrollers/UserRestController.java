package com.works.securityjwt.restcontrollers;

import com.works.securityjwt.entities.User;
import com.works.securityjwt.props.JWTLogin;
import com.works.securityjwt.services.UserDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {
    
   final UserDetailService uService;

    public UserRestController(UserDetailService uService) {
        this.uService = uService;
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){
        return  uService.register(user);
    }

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody JWTLogin jwtLogin ){
        return  uService.auth(jwtLogin);
    }


}
