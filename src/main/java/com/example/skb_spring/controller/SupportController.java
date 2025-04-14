package com.example.skb_spring.controller;

import com.example.skb_spring.dto.UserDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/support/api")
public class SupportController {

    @GetMapping
    public UserDto supportGetMethod(@AuthenticationPrincipal UserDetails userDetail) {
        return new UserDto(userDetail.getUsername(),userDetail.getAuthorities().toString());
    }

}
