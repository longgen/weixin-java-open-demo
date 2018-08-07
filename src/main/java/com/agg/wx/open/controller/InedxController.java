package com.agg.wx.open.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by longgen on 2018-07-25 14:37
 */
@Controller
@RequestMapping("/")
public class InedxController {

    @RequestMapping("/")
    public String index() {
        return  "forward:/index.html";
    }
}
