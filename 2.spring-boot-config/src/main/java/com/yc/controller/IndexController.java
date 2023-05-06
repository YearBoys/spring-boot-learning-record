package com.yc.controller;

import com.yc.bean.ConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 16:10 2023/5/6
 */
@RestController
public class IndexController {

   final  ConfigBean configBean;

    public IndexController(ConfigBean configBean) {
        this.configBean = configBean;
    }

    @GetMapping("/index")
    String  index(){
      return configBean.getName()+":"+configBean.getTitle()+":"+configBean.getWholeTitle();
  }

}
