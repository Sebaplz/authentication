package com.seba.authentication.controllers;

import com.seba.authentication.models.LoginUser;
import com.seba.authentication.models.User;
import com.seba.authentication.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Users {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("register", new User());
        model.addAttribute("login", new LoginUser());
        return "loginAndRegister.jsp";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("login") LoginUser loginuser, BindingResult result, Model model, HttpSession session) {
        if(result.hasErrors()) {
            model.addAttribute("register", new User());
            return "loginAndRegister.jsp";
        }
        if (!userService.authenticateUser(loginuser.getEmail(), loginuser.getPassword())){
            model.addAttribute("error", "Credenciales invalidas!");
            model.addAttribute("register", new User());
            return "loginAndRegister.jsp";
        }
        User user = userService.findByEmail(loginuser.getEmail());
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }

    @PostMapping("/registration")
    public String register(@Valid @ModelAttribute("register") User user, BindingResult result, Model model, HttpSession session) {
        if(result.hasErrors()) {
            model.addAttribute("login", new LoginUser());
            return "loginAndRegister.jsp";
        }

        try {
            User user1 = userService.registerUser(user);
            session.setAttribute("userId", user1.getId());
            return "redirect:/home";
        } catch (DataIntegrityViolationException e) {
            result.rejectValue("email", "error.email", "El email ingresado ya está en uso. Por favor, ingrese otro email.");
            model.addAttribute("login", new LoginUser());
            return "loginAndRegister.jsp";
        }

    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model){
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null){
            return "redirect:/";
        }
        User user = userService.findUserById(userId);
        model.addAttribute("user",user);
        return "homePage.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

}


