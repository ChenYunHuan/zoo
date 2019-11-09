package com.chen.pro.zoo.service;

import com.chen.pro.zoo.entity.Girl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ExcelService {
    List<Girl> findAll();

    void excelGirls(HttpServletResponse response, HttpServletRequest request);
}
