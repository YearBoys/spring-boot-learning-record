package com.yc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 14:44 2023/5/9
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    private Long id;

    private String name;

    private Long age;

    private String eMail;

}
