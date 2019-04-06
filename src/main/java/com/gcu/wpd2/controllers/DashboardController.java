package com.gcu.wpd2.controllers;

import com.gcu.wpd2.models.Project;
import com.gcu.wpd2.models.User;
import com.gcu.wpd2.services.ProjectService;
import com.gcu.wpd2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class DashboardController {
  @Autowired
  private UserService userService;
  @Autowired
  private ProjectService projectService;

  @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
  public ModelAndView getDashboardPage() {
    ModelAndView modelAndView = new ModelAndView();

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userService.findByEmail(auth.getName());
    List<Project> projects = projectService.getAllByUserEmail(user.getEmail());

    modelAndView.addObject("currentUser", user);
    modelAndView.addObject("userProjects", projects);
    modelAndView.setViewName("dashboard");

    return modelAndView;
  }
}
