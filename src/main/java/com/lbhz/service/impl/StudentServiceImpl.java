package com.lbhz.service.impl;

import com.lbhz.common.response.BaseResult;
import com.lbhz.common.response.BaseResultFactory;
import com.lbhz.common.response.Code;
import com.lbhz.core.bean.auto.RecordBean;
import com.lbhz.core.bean.auto.StudentBean;
import com.lbhz.core.bean.auto.StudentBeanExample;
import com.lbhz.core.dao.auto.RecordBeanMapper;
import com.lbhz.core.dao.auto.StudentBeanMapper;
import com.lbhz.model.RecordDto;
import com.lbhz.service.StudentServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 16:35
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentServer {
    @Value("${file.file-server-path}")
    private String fileServerPath;
    @Value("${file.file-server-url}")
    private String fileServerUrl;

    @Autowired
    private StudentBeanMapper studentBeanMapper;
    @Autowired
    private RecordBeanMapper recordBeanMapper;

    @Override
    public BaseResult updateRecord(MultipartFile multipartFile, RecordDto recordDto) throws IOException {
        //获取文件后缀
        log.info("文件名：{}", multipartFile.getOriginalFilename());
        String fileType = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf('.'));

        //获取学生信息
        StudentBean studentBean = studentBeanMapper.selectByPrimaryKey(recordDto.getStudentId());
        if (ObjectUtils.isEmpty(studentBean)) {
            return BaseResultFactory.produceEmptyResult(Code.STUDENT_ID_NOT_FIND);
        }
        log.info("{} 上传了记录信息,上传的文件是{}文件", studentBean.getName(), fileType);

        //保存文件到服务器所在路径
        File file = new File(fileServerPath, studentBean.getName() + "-" + recordDto.getWeekNum() + "-" + System.currentTimeMillis()%1000000 + fileType);
        multipartFile.transferTo(file);
        log.info("保存的位置：{}", file.getAbsolutePath());
        String url = fileServerUrl + file.getName();
        log.info("该文件的url: {}", url);

        //存入数据库
        RecordBean recordBean = RecordBean.builder()
                .studentId(studentBean.getId())
                .screenshot(url)
                .timeLenth(recordDto.getTimeLength())
                .weekNum(recordDto.getWeekNum())
                .createTime(LocalDateTime.now()).build();
        int insert = recordBeanMapper.insert(recordBean);
        return BaseResultFactory.produceEmptyResult(Code.SUCCESS);
    }

    @Override
    public BaseResult queryStudentInfo(String studentId) {
        //查询数据库
        StudentBeanExample example = new StudentBeanExample();
        example.createCriteria()
                .andIdEqualTo(studentId);
        List<StudentBean> studentBeans = studentBeanMapper.selectByExample(example);
        return BaseResultFactory.produceResult(Code.SUCCESS, studentBeans);
    }
}
