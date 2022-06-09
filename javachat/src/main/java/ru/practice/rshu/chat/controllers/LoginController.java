package ru.practice.rshu.chat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
    private String name;
    //UserModel
    @GetMapping("/")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/chat")
    public String goToChat(){
        return "chat";
    }

    @GetMapping(value = "/users")
    public String getUser(@RequestParam("name") String name, Model model) {
        try {
            System.out.println(name);
            return "redirect:chat";
        }
        catch (Exception e){

        }
        return "redirect:chat";
    }
}
