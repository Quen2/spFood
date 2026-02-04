package com.cda.spfood.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value="/test", produces="application/json")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
