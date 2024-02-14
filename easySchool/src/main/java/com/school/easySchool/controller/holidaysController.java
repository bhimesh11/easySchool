package com.school.easySchool.controller;

import com.school.easySchool.Repository.HolidaysRepository;
import com.school.easySchool.domain.holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
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
    private HolidaysRepository holidaysRepository;

    public holidaysController(HolidaysRepository holidaysRepository) {
        this.holidaysRepository = holidaysRepository;
    }

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {
        if (null != display && display.equals("all")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        } else if (null != display && display.equals("federal")) {
            model.addAttribute("federal", true);

        } else if (null != display && display.equals("festival")) {
            model.addAttribute("festival", true);
        }
        List<holiday> holidays = holidaysRepository.findAll();

        holiday.Type[] types = holiday.Type.values();

        for (holiday.Type type : types) {
            model.addAttribute(type.toString(), (holidays.stream().filter(holiday -> holiday.getType().equals(type))).collect(Collectors.toList()));
        }
        return "holidays.html";
    }
}
