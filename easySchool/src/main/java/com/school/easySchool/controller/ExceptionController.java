package com.school.easySchool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class ExceptionController
{
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e)
    {
        ModelAndView errorPage = new ModelAndView();
        errorPage.setViewName("error");
        errorPage.addObject("errormsg",e.getMessage());
        return errorPage;
    }
}
