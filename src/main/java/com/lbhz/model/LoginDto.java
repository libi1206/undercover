package com.lbhz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 15:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String userName;
    private String password;
}
