package com.lbhz.controller;

import com.lbhz.common.response.BaseResult;
import com.lbhz.config.anno.RequestToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.lbhz.common.Const.ACCESS_PARAM;
/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 16:23
 */
@RestController
@Slf4j
@Api("管理端的接口在这")
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/list")
    @ApiOperation("查询列表")
    @RequestToken
    public BaseResult queryRecordList(
            @RequestHeader(ACCESS_PARAM) String token,
            @RequestParam Integer page,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) Integer weekNum,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String major,
            @RequestParam(required = false) String studentId
    ) {
        return null;
    }

}
