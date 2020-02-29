package com.lbhz.undercover;

import com.lbhz.core.bean.auto.StudentBean;
import com.lbhz.core.dao.auto.StudentBeanMapper;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class UndercoverApplicationTests {
    @Autowired
    private StudentBeanMapper studentBeanMapper;


    @Test
    void contextLoads() throws Exception {
        if (studentBeanMapper == null) {
            throw new Exception();
        }
    }

}
