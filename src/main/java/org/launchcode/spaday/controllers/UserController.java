package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model, String verify) {

        if (errors.hasErrors()) {
            System.out.println("Some errors present.");
            return "user/add";
        }

        if (user.getPassword().equals(verify)) {
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords do not match.");
            System.out.println("Password problem.");
            return "user/add";
        }




    }

}
