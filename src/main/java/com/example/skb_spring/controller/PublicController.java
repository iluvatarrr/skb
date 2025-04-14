package com.example.skb_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/api")
public class PublicController {

    @GetMapping
    public ResponseEntity<?> publicGetMethod() {
        return ResponseEntity.ok("Public");
    }

}
