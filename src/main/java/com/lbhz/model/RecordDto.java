package com.lbhz.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 16:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class RecordDto {
    private String studentId;
    private Integer timeLength;
    @ApiModelProperty("只要1234就好")
    private Integer weekNum;
}
