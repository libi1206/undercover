package com.lbhz.core.dao;

import com.lbhz.core.bean.AdminListVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 18:16
 */
@Repository
public interface AdminMapper {
    List<AdminListVo> queryRecordList(
            @Param("startRow") Integer startRow,
            @Param("pageSize") Integer pageSize,
            @Param("weekNum") Integer weekNum,
            @Param("name") String name,
            @Param("major") String major,
            @Param("club") String club,
            @Param("studentId") String studentId
    );

    Long countList(
            @Param("weekNum") Integer weekNum,
            @Param("name") String name,
            @Param("major") String major,
            @Param("club") String club,
            @Param("studentId") String studentId
    );
}
