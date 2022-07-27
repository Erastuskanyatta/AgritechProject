<<<<<<< HEAD
package com.example.agritech.MobileApp.Controller;
import ExeptionHandler.emailAlreadyTakenException;
import com.example.agritech.MobileApp.Config.SecurityConfiguration;
import com.example.agritech.MobileApp.JWT.JWTResponse;
import com.example.agritech.MobileApp.JWT.JwtRequest;
import com.example.agritech.MobileApp.JWT.jwtUtility;

import com.example.agritech.MobileApp.Services.MobileUserService;
import com.example.agritech.WebApp.Model.AppUsers;
import com.sun.tools.jconsole.JConsoleContext;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
@RestController
public class MobileUserController {

    private SecurityConfiguration securityConfiguration;
@Autowired
    private final JwtRequest jwtRequest;
    @Autowired
    private jwtUtility jwtUtility;
    @Autowired
    private final MobileUserService mobileUserService;

    @Autowired
    private ApplicationEventPublisher publisher;
    private AuthenticationManager authenticationManager;

    public MobileUserController(JwtRequest jwtRequest, MobileUserService mobileUserService) {
        this.jwtRequest = jwtRequest;
        this.mobileUserService = mobileUserService;

    }
    @GetMapping("/")
    public  String home(){
        return "Welcome Home";
    }
    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTResponse jwtResponse) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUserName(),
                            jwtRequest.getPassword()
                    )
            );
        }catch (BadCredentialsException e){
            throw new Exception("bad credentials", e);

        }
        final UserDetails userDetails= mobileUserService.loadUserByUsername(jwtRequest.getUserName());
        final String token = jwtUtility.generateToken((AppUsers) userDetails);
        return new JWTResponse(token);
    }
}
=======
package com.example.agritech.MobileApp.Controller;
import ExeptionHandler.emailAlreadyTakenException;
import com.example.agritech.MobileApp.Config.SecurityConfiguration;
import com.example.agritech.MobileApp.JWT.JWTResponse;
import com.example.agritech.MobileApp.JWT.JwtRequest;
import com.example.agritech.MobileApp.JWT.jwtUtility;

import com.example.agritech.MobileApp.Services.MobileUserService;
import com.example.agritech.WebApp.Model.AppUsers;
import com.sun.tools.jconsole.JConsoleContext;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
@RestController
public class MobileUserController {

    private SecurityConfiguration securityConfiguration;
@Autowired
    private final JwtRequest jwtRequest;
    @Autowired
    private jwtUtility jwtUtility;
    @Autowired
    private final MobileUserService mobileUserService;

    @Autowired
    private ApplicationEventPublisher publisher;
    private AuthenticationManager authenticationManager;

    public MobileUserController(JwtRequest jwtRequest, MobileUserService mobileUserService) {
        this.jwtRequest = jwtRequest;
        this.mobileUserService = mobileUserService;

    }
    @GetMapping("/")
    public  String home(){
        return "Welcome Home";
    }
    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTResponse jwtResponse) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUserName(),
                            jwtRequest.getPassword()
                    )
            );
        }catch (BadCredentialsException e){
            throw new Exception("bad credentials", e);

        }
        final UserDetails userDetails= mobileUserService.loadUserByUsername(jwtRequest.getUserName());
        final String token = jwtUtility.generateToken((AppUsers) userDetails);
        return new JWTResponse(token);
    }
}
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
