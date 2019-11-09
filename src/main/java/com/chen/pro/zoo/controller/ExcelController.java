package com.chen.pro.zoo.controller;

import com.chen.pro.zoo.entity.Girl;
import com.chen.pro.zoo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("excel")
public class ExcelController {
    @Autowired
    private ExcelService excelService;
    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return excelService.findAll();
    }

    /**
     * 导出excel
     */
    @RequestMapping(value = "/export")
    public void excelContactLineInfo(HttpServletResponse response, HttpServletRequest request){
        excelService.excelGirls(response,request);
    }
}
