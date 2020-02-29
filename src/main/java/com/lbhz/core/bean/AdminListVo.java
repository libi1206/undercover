package com.lbhz.core.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 18:17
 */
@Data
public class AdminListVo {
    private String studentId;
    private String name;
    private String major;
    private String club;
    private Integer weekNum;
    private Integer timeLength;
    private String screenshot;
    private LocalDateTime createTime;
}
