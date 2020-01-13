package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestKontroler {


    @RequestMapping("/test.html")
    public String test(){
        return "Test";
    }

}
