package com.chen.pro.zoo.controller;

import com.chen.pro.zoo.service.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "girl")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        System.out.println(girlProperties.getAge());
        return "1111111111";
    }

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayGoodBy(@RequestParam("id") Integer id){
        return id.toString();
    }

    @RequestMapping(value = "/{id}/hi",method = RequestMethod.GET)
    public String sayGoodBy1(@PathVariable("id") Integer id){
        return id.toString();
    }
}
