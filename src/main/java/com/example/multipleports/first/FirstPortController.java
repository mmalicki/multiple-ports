package com.example.multipleports.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstPortController {
    @GetMapping("a")
    @ResponseBody
    public String ff(){
        return "a";
    }
}
