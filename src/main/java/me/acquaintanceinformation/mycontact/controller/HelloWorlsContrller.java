package me.acquaintanceinformation.mycontact.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorlsContrller {

    @GetMapping(value = "/api/helloWord")
    public String helloWorld(){
        return "HelloWorld";
    }

}
