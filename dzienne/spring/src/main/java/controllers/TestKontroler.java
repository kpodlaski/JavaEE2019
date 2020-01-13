package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestKontroler {


    @RequestMapping("/test.html")
    public String test(){
        return "Test";
    }

    @RequestMapping("/info.html")
    public ModelAndView test2(){
        String info = " To jest Informacja do wyświetlenia";
        ModelAndView mv = new ModelAndView("Test");
        mv.getModel().put("data",info);
        return mv;
    }

}
