package com.github.dolphin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ste7en.liu@gmail.com
 * @version 1.0.0
 * @since 2017/7/23
 */

@Controller
@RequestMapping("/home")
public class IndexController {


    @GetMapping("/main")
    public String main() {


        return "main";
    }
}
