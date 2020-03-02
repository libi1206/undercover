package com.lbhz.service.impl;

import com.lbhz.common.response.BaseResult;
import com.lbhz.common.response.BaseResultFactory;
import com.lbhz.common.response.Code;
import com.lbhz.core.bean.AdminListVo;
import com.lbhz.core.dao.AdminMapper;
import com.lbhz.model.RecordListVo;
import com.lbhz.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public BaseResult downLoadExcel(Integer weekNum) {
        return null;
    }
}
