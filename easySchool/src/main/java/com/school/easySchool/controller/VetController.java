package com.school.easySchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController
{
  //  @RequestMapping("","/","/home")
    @RequestMapping(value={"","/","/home"} )
    public String displayPage()
    {
    //  model.addAttribute("username","Bhimesh Ganji");
        return "home.html";
    }
}
