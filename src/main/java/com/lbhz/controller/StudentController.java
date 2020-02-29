package com.lbhz.controller;

import com.lbhz.common.response.BaseResult;
import com.lbhz.model.RecordDto;
import com.lbhz.service.StudentServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 16:08
 */
@RestController
@Slf4j
@Api
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentServer studentServer;

    @PostMapping("/record")
    @ApiOperation("学生上传运动记录")
    public BaseResult updateRecord(
            @ApiParam(value = "文件", required = true) MultipartFile file,
            @ApiParam(value = "运动记录信息") RecordDto recordDto
    ) throws IOException {
        return studentServer.updateRecord(file,recordDto);
    }

    @GetMapping("/query")
    @ApiParam("根据学生学号查询信息")
    public BaseResult queryStudentInfo(
            @ApiParam("学号") @RequestParam String studentId
    ) {
        return studentServer.queryStudentInfo(studentId);
    }
}
