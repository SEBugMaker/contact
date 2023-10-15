package com.contact.contact.web;


import com.contact.contact.Contact;
import com.contact.contact.data.contactRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/home")
public class ContactController {


    @Autowired
    private com.contact.contact.data.contactRepository contactRepository;

    @Autowired
    public ContactController(contactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @GetMapping
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("contactlist", contactRepository.findAll());
        return "home";
    }
    @PostMapping
    public String submitForm(@ModelAttribute("contact") @Valid Contact contact,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contactlist",contactRepository.findAll());
            return "home";
        }

        //contactRepository.save(contact);
        contactRepository.save(contact);
        model.addAttribute("contact", new Contact());
        model.addAttribute("contactlist", contactRepository.findAll());
        return "home";
    }

}
