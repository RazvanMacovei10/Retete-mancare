package com.spring.macoveirazvanionut.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    String rawPassword="1234";
    String encodedPassword=encoder.encode(rawPassword);
}
