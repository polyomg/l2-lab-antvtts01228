package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OkController {

    @RequestMapping("/ctrl/ok")
    public String ok() {
        return "ok";  // Phải trả về "ok" (tên file ok.html)
    }

    @RequestMapping(value = "/ctrl/ok", method = RequestMethod.POST)
    public String m1(Model model) {
        model.addAttribute("methodName", "m1() - POST method");
        return "ok";
    }

    @RequestMapping(value = "/ctrl/ok", method = RequestMethod.GET)
    public String m2(Model model) {
        model.addAttribute("methodName", "m2() - GET method");
        return "ok";
    }

    @RequestMapping(value = "/ctrl/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("methodName", "m3() - With parameter x");
        return "ok";
    }
}