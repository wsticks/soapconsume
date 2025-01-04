package com.williams.soapconsumeapp.controller;

import com.williams.soapconsumeapp.service.SoapClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/soap")
public class SoapClientController {

    @Autowired
    private SoapClientService soapClientService;

    @PostMapping("/ping")
    public String ping(){
        return soapClientService.ping("Hello");
    }

    @GetMapping("/{number}")
    public String findById(@PathVariable int number){
        return soapClientService.findById( number);
    }
}
