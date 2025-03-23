package com.example.secure_app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(path = "/greet", method = RequestMethod.GET)
    public String greet(@RequestParam(name = "name", defaultValue = "World") String name) {
        return String.format("<h1>Hello %s!</h1>", name);
    }

    @RequestMapping(path = "/secure/greet", method = RequestMethod.GET)
    public String secureGreet(@RequestParam(name = "name", defaultValue = "World") String name) {
        return String.format("<h1>Secure, Hello %s!</h1>", name);
    }
}
