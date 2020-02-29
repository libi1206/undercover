package com.lbhz.undercover;

import com.lbhz.core.bean.auto.StudentBean;
import com.lbhz.core.dao.auto.StudentBeanMapper;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@MapperScan(basePackages = {"com.lbhz.core.dao"})
@ComponentScan(basePackages = {"com.lbhz.*"})
@Slf4j
public class InsertStudent {

    public static void main(String[] args) throws IOException, BiffException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(InsertStudent.class, args);
        StudentBeanMapper bean = applicationContext.getBean(StudentBeanMapper.class);
        insertStudentInfo(bean);
        applicationContext.stop();
        System.exit(0);
    }


    private static String filePath = "/Users/libi/Downloads/名单.xls";
    private static void insertStudentInfo(StudentBeanMapper studentBeanMapper) throws IOException, BiffException {
        //文件名
        File file = new File(filePath);
        //获得工作簿
        Workbook workbook = null;
        workbook = Workbook.getWorkbook(file);
        int numberOfSheets = workbook.getNumberOfSheets();
        log.info("页数：{}", numberOfSheets);
        //获得sheet
        for (int j = 0; j < numberOfSheets; j++) {
            Sheet sheet = workbook.getSheet(j);
            //获得行数
            log.info("第{}页，行数：{}",j+1 , sheet.getRows());
            //开始插入数据
            for (int i = 1; i < sheet.getRows(); i++) {
                //读取数据
                Cell[] row = sheet.getRow(i);
                //构建学生数据
                StudentBean studentBean = StudentBean.builder()
                        .id(row[0].getContents())
                        .name(row[1].getContents())
                        .club(sheet.getName())
                        .major(row[3].getContents()).build();
                //插入
                studentBeanMapper.insert(studentBean);
                log.info("完成第{}个，共{}个",i+1,sheet.getRows());
            }
        }

    }
}
