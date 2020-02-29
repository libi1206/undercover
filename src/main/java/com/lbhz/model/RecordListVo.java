package com.lbhz.model;

import com.lbhz.core.bean.AdminListVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 18:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordListVo {
    private List<AdminListVo> list;
    private Long total;
}
