package com.school.easySchool.controller;

import com.school.easySchool.domain.holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class holidaysController {


    @GetMapping("/holidays")
    public String displayholidays(@RequestParam(required = true) boolean festival, @RequestParam(required = false) boolean federal, Model model) {
        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);
        List<holiday> holidays =
                Arrays.asList(
                        new holiday(" Jan 1 ", "New Year's Day", holiday.Type.FESTIVAL),
                        new holiday(" Oct 31 ", "Halloween", holiday.Type.FESTIVAL),
                        new holiday(" Nov 24 ", "Thanksgiving Day", holiday.Type.FESTIVAL),
                        new holiday(" Dec 25 ", "Christmas", holiday.Type.FESTIVAL),
                        new holiday(" Jan 17 ", "Martin Luther King Jr. Day", holiday.Type.FEDERAL),
                        new holiday(" July 4 ", "Independence Day", holiday.Type.FEDERAL),
                        new holiday(" Sep 5 ", "Labor Day", holiday.Type.FEDERAL),
                        new holiday(" Nov 11 ", "Veterans Day", holiday.Type.FEDERAL));
        holiday.Type[] types = holiday.Type.values();
        for (holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList()));

        }

        return "holidays.html";
    }

    @GetMapping(value = "/holidays/{display}")
    public String displayholidaysall(@PathVariable String display, Model model) {


        List<holiday> holidays =
                Arrays.asList(
                        new holiday(" Jan 1 ", "New Year's Day", holiday.Type.FESTIVAL),
                        new holiday(" Oct 31 ", "Halloween", holiday.Type.FESTIVAL),
                        new holiday(" Nov 24 ", "Thanksgiving Day", holiday.Type.FESTIVAL),
                        new holiday(" Dec 25 ", "Christmas", holiday.Type.FESTIVAL),
                        new holiday(" Jan 17 ", "Martin Luther King Jr. Day", holiday.Type.FEDERAL),
                        new holiday(" July 4 ", "Independence Day", holiday.Type.FEDERAL),
                        new holiday(" Sep 5 ", "Labor Day", holiday.Type.FEDERAL),
                        new holiday(" Nov 11 ", "Veterans Day", holiday.Type.FEDERAL));
        holiday.Type[] types = holiday.Type.values();
        for (holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList()));

        }
        if(display!=null && display.equals("all"))
        {
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        }
        else if(display.equals("festival"))
        {
            model.addAttribute("festival",true);
        }
        else if (display.equals("federal"))
        {
            model.addAttribute("federal",true);
        }
        return "holidays.html";
    }
}
