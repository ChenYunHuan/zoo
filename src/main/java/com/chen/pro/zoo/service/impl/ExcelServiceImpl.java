package com.chen.pro.zoo.service.impl;

import com.chen.pro.zoo.entity.Girl;
import com.chen.pro.zoo.repository.GirlRepository;
import com.chen.pro.zoo.service.ExcelService;
import com.chen.pro.zoo.util.Util;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    private GirlRepository girlRepository;

    @Override
    public List<Girl> findAll() {
        return girlRepository.findAll();
    }

    @Override
    public void excelGirls(HttpServletResponse response, HttpServletRequest request) {
        List<Girl> list = girlRepository.findAll();
        //excel文件名
        String fileName = "联络线信息" + System.currentTimeMillis() + ".xlsx";
        int num = 100;
        String[] title = new String[]{"序号", "联络线名称", "月度交易电量",
                "当月年度合约完成电量", "当月中短期完成电量", "年累计交易电量",
                "累计年度合约完成电量", "累计中短期完成电量"
        };
        String[][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            content[i][0] = i + 1 + "";
            content[i][1] = String.valueOf(list.get(i).getId());
            content[i][2] = String.valueOf(list.get(i).getAge());
            content[i][3] = String.valueOf(list.get(i).getSize());
        }
        Workbook wb = Util.getXSSFWorkbook(title, content);
        Util.setResponseHeader(response, fileName);
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            wb.write(os);
            os.flush();

        } catch (IOException e) {

        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
            }
        }

    }
}
