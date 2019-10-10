package com.chen.pro.zoo.controller;

import com.chen.pro.zoo.dao.IgirlMapper;
import com.chen.pro.zoo.entity.Girl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("gi")
public class GirlController {
    @Resource
    private IgirlMapper igirlMapper;

    @RequestMapping("findAll")
    public List<Girl> findAll(){
        return igirlMapper.queryAll();
    }
}
