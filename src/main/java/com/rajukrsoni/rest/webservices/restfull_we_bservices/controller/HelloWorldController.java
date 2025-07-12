package com.rajukrsoni.rest.webservices.restfull_we_bservices.controller;

import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response.HelloWorldResponseBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//RestController
@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    private HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    //hello-world
    //@RequestMapping( method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldResponseBean helloWorldBean(){
        return new HelloWorldResponseBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldResponseBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldResponseBean(String.format("Hello World, %s" , name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(){

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default message", locale);
    }

}
