package lt.codeacademy.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class MyFirstController {

    @GetMapping
    public ModelAndView hello() {
        ModelAndView model = new ModelAndView("firstTemplate");
        return model;
    }

    @GetMapping("/secondExample/{name}")
    public String secondMethod(@PathVariable String name, @RequestParam(required = false) String param) {  //jei vardai skirtusi -nerastu pvz (@PathVariable("name") String myName)
        System.out.println(name);
        return "firstTemplate";
    }
}
