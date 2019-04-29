package com.gcu.wpd2.controllers;

import javax.validation.Valid;
import com.gcu.wpd2.models.User;
import com.gcu.wpd2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView viewLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(new User());
        modelAndView.addObject("currentUser", getCurrentUser());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView viewSignupPage() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.addObject("currentUser", getCurrentUser());
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView createUserFromSignupForm(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user",
              "Email already taken!");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
            return modelAndView;
        }
        userService.saveUserAndHashPassword(user);
        modelAndView.addObject("registered", true);
        modelAndView.addObject("currentUser", getCurrentUser());
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
    
    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public ModelAndView viewHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("currentUser", getCurrentUser());
        return modelAndView;
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public ModelAndView view404Page() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("currentUser", getCurrentUser());
        modelAndView.setViewName("404");
        return modelAndView;
    }

    User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findByEmail(auth.getName());
    }
}
