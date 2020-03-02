package com.lbhz.undercover;

import com.lbhz.core.bean.AdminListVo;
import com.lbhz.core.bean.auto.StudentBean;
import com.lbhz.core.dao.AdminMapper;
import com.lbhz.core.dao.auto.StudentBeanMapper;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class UndercoverApplicationTests {
    @Autowired
    private StudentBeanMapper studentBeanMapper;
    @Autowired
    private AdminMapper adminMapper;


    @Test
    void contextLoads() throws Exception {
        if (studentBeanMapper == null) {
            throw new Exception();
        }
    }

    @Test
    void testCreateXls() throws IOException, WriteException {
        //获取对应周数的列表
        List<AdminListVo> adminListVos = adminMapper.queryRecordList(null, null, 1, null, null, null, null);
        log.info("查询的记录共{}条", adminListVos.size());
        //创建文件
        File weekXls = new File("/Users/libi/Downloads", "第1周.xls");
        if (weekXls.exists()) {
            weekXls.delete();
        }
        WritableWorkbook workbook = Workbook.createWorkbook(weekXls);
        //获得sheet
        WritableSheet sheet = workbook.createSheet("sheet",0);
        //创建表头
        sheet.addCell(new Label(0,0,"学号"));
        sheet.addCell(new Label(1,0,"姓名"));
        sheet.addCell(new Label(2,0,"班级"));
        sheet.addCell(new Label(3,0,"俱乐部"));
        sheet.addCell(new Label(4,0,"周次"));
        sheet.addCell(new Label(5,0,"时长"));
        sheet.addCell(new Label(6,0,"图片url"));
        sheet.addCell(new Label(7,0,"上传时间"));
        //插入表中
        for (int i = 0; i < adminListVos.size(); i++) {
            sheet.addCell(new Label(0, i+1, adminListVos.get(i).getStudentId()));
            sheet.addCell(new Label(1, i+1, adminListVos.get(i).getName()));
            sheet.addCell(new Label(2, i+1, adminListVos.get(i).getMajor()));
            sheet.addCell(new Label(3, i+1, adminListVos.get(i).getClub()));
            sheet.addCell(new Label(4, i+1, adminListVos.get(i).getWeekNum().toString()));
            sheet.addCell(new Label(5, i+1, adminListVos.get(i).getTimeLength().toString()));
            sheet.addCell(new Label(6, i+1, adminListVos.get(i).getScreenshot()));
            sheet.addCell(new Label(7, i+1, adminListVos.get(i).getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-DD HH:mm:ss"))));
        }
        workbook.write();
        workbook.close();
    }

}
