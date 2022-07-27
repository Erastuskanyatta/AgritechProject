package com.example.agritech.MobileApp.JWT;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;


@Component
public interface AuthenticationManager {


    Authentication authenticate(Authentication authentication) throws AuthenticationException;
}

