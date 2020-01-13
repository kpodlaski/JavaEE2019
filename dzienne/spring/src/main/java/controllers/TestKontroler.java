package controllers;

import model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        Person p = new Person("Adam",
                "Adamczewski",
                42);
        mv.getModel().put("person",p);
        return mv;
    }

    @RequestMapping(name="person.html",method = RequestMethod.POST)
    public ModelAndView test3(String imie, String nazwisko, int ssize){
        ModelAndView mv = new ModelAndView("Test");
        Person p = new Person(imie, nazwisko,ssize);
        mv.getModel().put("person",p);
        return mv;
    }

    @RequestMapping("person2.html")
    public ModelAndView test3(Person p){
        ModelAndView mv = new ModelAndView("Test");
        mv.getModel().put("person",p);
        return mv;
    }

    @RequestMapping("person/{imie}/{nazwisko},{shoeSize}")
    public ModelAndView test4(@PathVariable String imie,
                              @PathVariable String nazwisko,
                              @PathVariable int shoeSize){
        ModelAndView mv = new ModelAndView("Test");
        Person p = new Person(imie, nazwisko,shoeSize);
        mv.getModel().put("person",p);
        return mv;
    }
}
