package com.lili.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lili.domains.Contact;

@Controller
public class ContactController {
	
	@RequestMapping("/contact")
    public String sendContact(Model model){
        model.addAttribute("contact", new Contact());
        return "contactform";
    }
	
	@RequestMapping(value="contactsuccess", method = RequestMethod.POST)
    public String submitContact(@Valid Contact contact, BindingResult bindingResult){		
						
		if (bindingResult.hasErrors()) {
			return "contactform";
		}	
		
	    return "contactsuccess";
    }
	
}
