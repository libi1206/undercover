package com.lbhz.service.impl;

import com.lbhz.common.response.BaseResult;
import com.lbhz.common.response.BaseResultFactory;
import com.lbhz.common.response.Code;
import com.lbhz.core.bean.AdminListVo;
import com.lbhz.core.dao.AdminMapper;
import com.lbhz.model.RecordListVo;
import com.lbhz.service.AdminService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 18:15
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Value("${file.file-server-path}")
    private String fileServerPath;
    @Value("${file.file-server-url}")
    private String fileServerUrl;

    @Override
    public BaseResult queryRecordList(Integer page, Integer pageSize, Integer weekNum, String name, String major, String club, String studentId) {
        List<AdminListVo> adminListVos = adminMapper.queryRecordList((page - 1) * pageSize, pageSize, weekNum, name, major, club, studentId);
        Long total = adminMapper.countList(weekNum, name, major, club, studentId);
        RecordListVo build = RecordListVo.builder()
                .list(adminListVos)
                .total(total).build();
        return BaseResultFactory.produceResult(Code.SUCCESS, build);
    }

    @Override
    public BaseResult downLoadExcel(Integer weekNum) throws IOException, WriteException {
        //获取对应周数的列表
        List<AdminListVo> adminListVos = adminMapper.queryRecordList(null, null, weekNum, null, null, null, null);
        log.info("查询第{}记录共{}条", weekNum, adminListVos.size());
        //创建文件
        File weekXls = new File(fileServerPath, "第" + weekNum + "周.xls");
        if (weekXls.exists()) {
            weekXls.delete();
        }
        WritableWorkbook workbook = Workbook.createWorkbook(weekXls);
        //获得sheet
        WritableSheet sheet = workbook.createSheet("sheet", 0);
        //创建表头
        sheet.addCell(new Label(0, 0, "学号"));
        sheet.addCell(new Label(1, 0, "姓名"));
        sheet.addCell(new Label(2, 0, "班级"));
        sheet.addCell(new Label(3, 0, "俱乐部"));
        sheet.addCell(new Label(4, 0, "周次"));
        sheet.addCell(new Label(5, 0, "时长"));
        sheet.addCell(new Label(6, 0, "图片url"));
        sheet.addCell(new Label(7, 0, "上传时间"));
        //插入表中
        for (int i = 0; i < adminListVos.size(); i++) {
            sheet.addCell(new Label(0, i + 1, adminListVos.get(i).getStudentId()));
            sheet.addCell(new Label(1, i + 1, adminListVos.get(i).getName()));
            sheet.addCell(new Label(2, i + 1, adminListVos.get(i).getMajor()));
            sheet.addCell(new Label(3, i + 1, adminListVos.get(i).getClub()));
            sheet.addCell(new Label(4, i + 1, adminListVos.get(i).getWeekNum().toString()));
            sheet.addCell(new Label(5, i + 1, adminListVos.get(i).getTimeLength().toString()));
            sheet.addCell(new Label(6, i + 1, adminListVos.get(i).getScreenshot()));
            sheet.addCell(new Label(7, i + 1, adminListVos.get(i).getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-DD HH:mm:ss"))));
        }
        workbook.write();
        workbook.close();
        //拼接url
        String url = fileServerUrl + weekXls.getName();
        log.info("完成，输出文件路径{}", weekXls.getAbsolutePath());
        return BaseResultFactory.produceResult(Code.SUCCESS, url);
    }
}
