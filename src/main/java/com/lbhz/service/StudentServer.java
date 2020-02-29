package com.lbhz.service;

import com.lbhz.common.response.BaseResult;
import com.lbhz.model.RecordDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 16:34
 */
public interface StudentServer {

    BaseResult updateRecord(MultipartFile multipartFile, RecordDto recordDto) throws IOException;

    BaseResult queryStudentInfo(String  studentId);
}
