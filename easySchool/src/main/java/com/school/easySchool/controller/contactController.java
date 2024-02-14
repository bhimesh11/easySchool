package com.school.easySchool.controller;

import com.school.easySchool.domain.Contact;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import com.school.easySchool.service.contactService;

import java.util.List;

@Controller
@Slf4j
@SessionScope
public class contactController
{

    private contactService contactService;

    public contactController(contactService contactService) {
        this.contactService = contactService;
    }

  //  private static Logger log = LoggerFactory.getLogger(contactController.class);

    @RequestMapping(value = {"/contact"})
    public String displayContacts(Model model)
    {
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }
//    @PostMapping(value = "/saveMsg")
//    public ModelAndView saveMessage(@RequestParam String name ,
//                                    @RequestParam String mobileNum,
//                                    @RequestParam String email,
//                                    @RequestParam  String subject,
//                                    @RequestParam String message)
//    {
//        log.info("Name is: " + name);
//        log.info("mobile number: " +mobileNum );
//        log.info("email:" +email);
//        log.info("Subject: " + subject);
//        log.info("Message is " + message);
//        return new ModelAndView("redirect:/contact");
//    }

    @RequestMapping(value = {"/saveMsg"},method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors error)
    {
        if(error.hasErrors())
        {
            log.error("Contact form validation failed due to "+ error.toString());
            return "contact.html";
        }
       contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
    @RequestMapping( "/displayMessages")
    public ModelAndView displayMessage(Model model)
    {
        List<Contact> contactMsgs = contactService.findMsgwithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs",contactMsgs);

        return modelAndView;
    }
    @RequestMapping(value = "/closeMsg",method = RequestMethod.GET)
    public String closeMsg(@RequestParam int id)
    {
     contactService.updateMsgStatus(id);
     return "redirect:/displayMessages";
    }
}
