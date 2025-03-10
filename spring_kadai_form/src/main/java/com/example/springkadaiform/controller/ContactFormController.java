package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;






@Controller
public class ContactFormController {

    
    @GetMapping("/form")
    public String showContactForm(Model model) {
    	if (!model.containsAttribute("contactForm")) {
    		model.addAttribute("contactForm", new ContactForm());
    	}      
        return "contactFormView";
    }

    
    @PostMapping("/form/confirm")
    public String confirmContactForm(
        @Valid @ModelAttribute ContactForm contactForm,
        BindingResult result,
        RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
        	
        	redirectAttributes.addFlashAttribute("contactForm", contactForm);
        	
        	redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
            
     
            return "redirect:/form";
        }

        return "confirmView";
    }
    
    
   
    @PostMapping("/form/submit")
    public String submitContactForm(@ModelAttribute ContactForm contactForm) {
     
        return "completeView";
    }
}