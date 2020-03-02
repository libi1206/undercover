package com.lbhz.service;

import com.lbhz.common.response.BaseResult;
import io.swagger.models.auth.In;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 17:06
 */
public interface AdminService {
    BaseResult queryRecordList(Integer page, Integer pageSize, Integer weekNum, String name, String major, String club, String studentId);

    BaseResult downLoadExcel(Integer weekNum);
}
