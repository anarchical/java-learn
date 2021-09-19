package com.leaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YeYaqiao
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/getView")
    public String getView(){
        return "index";
    }

    @GetMapping("/mode_and_view")
    public ModelAndView getModelAndView(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("modelAndView");
        modelAndView.addObject("name","ModelAndView");
        return modelAndView;
    }
}
