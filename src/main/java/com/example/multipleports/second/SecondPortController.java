package com.example.multipleports.second;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecondPortController {
    @GetMapping("b")
    @ResponseBody
    public String ff(){
        return "bbb";
    }
}
