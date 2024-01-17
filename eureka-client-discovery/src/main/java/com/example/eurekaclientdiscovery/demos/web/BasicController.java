package com.example.eurekaclientdiscovery.demos.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class BasicController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(name = "name", defaultValue = "unknown user") String name) {
        return "Hello " + name;
    }
}
