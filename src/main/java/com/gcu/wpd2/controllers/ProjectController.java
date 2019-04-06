package com.gcu.wpd2.controllers;

import com.gcu.wpd2.models.Project;
import com.gcu.wpd2.models.User;
import com.gcu.wpd2.services.ProjectService;
import com.gcu.wpd2.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {
  @Autowired
  private ProjectService projectService;
  @Autowired
  private UserService userService;

  @RequestMapping(value = "/project/create", method = RequestMethod.GET)
  public ModelAndView getCreateProjectPage() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject(new Project());
    modelAndView.setViewName("project/create");
    return  modelAndView;
  }

  @RequestMapping(value = "/project", method = RequestMethod.POST)
  public RedirectView createProject(@Valid Project project, BindingResult bindingResult) {
    ModelAndView modelAndView = new ModelAndView();

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userService.findByEmail(auth.getName());
    Map<ObjectId, String> userProjects = projectService.getTitlesMappedById(user.getEmail());

    if (userProjects.containsValue(project.getTitle())) {
      bindingResult.rejectValue("name", "error.name", "Project with that name already exists");
    }
    if (bindingResult.hasErrors()) {
      modelAndView.setViewName("project/create");
      return new RedirectView("project/create");
    }
    System.out.println(project);
    projectService.save(project);
    List<Project> projects = projectService.getAllByUserEmail(user.getEmail());

    modelAndView.addObject("currentUser", user);
    modelAndView.addObject("userProjects", projects);
    modelAndView.setViewName("dashboard");

    return new RedirectView("dashboard");
  }
}
