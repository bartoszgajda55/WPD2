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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class ProjectController {
  @Autowired
  private ProjectService projectService;
  @Autowired
  private UserService userService;

  @RequestMapping(value = "/project/view/{projectId}", method = RequestMethod.GET)
  public ModelAndView getProjectDetailsPage(@PathVariable ObjectId projectId) {
    ModelAndView modelAndView = new ModelAndView();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    modelAndView.addObject("isLoggedInUserTheOwner", projectService.isUserOwnerOfTheProject(auth.getName(), projectService.getById(projectId)));
    modelAndView.addObject("project", projectService.getById(projectId));
    modelAndView.setViewName("project/view");
    return  modelAndView;
  }


  @RequestMapping(value = "/project/create", method = RequestMethod.GET)
  public ModelAndView getCreateProjectPage() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject(new Project());
    modelAndView.setViewName("project/create");
    return  modelAndView;
  }

  @RequestMapping(value = "/project", method = RequestMethod.POST)
  public ModelAndView createProject(@Valid Project project, BindingResult bindingResult) {
    ModelAndView modelAndView = new ModelAndView();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userService.findByEmail(auth.getName());
    Map<ObjectId, String> userProjects = projectService.getTitlesMappedById(user.getEmail());
    if (userProjects.containsValue(project.getTitle())) {
      bindingResult.rejectValue("title", "error.title", "Project with that title already exists");
    }
    if (bindingResult.hasErrors()) {
      modelAndView.setViewName("project/create");
      return modelAndView;
    }
    projectService.saveToUser(project, user);
    modelAndView.addObject("projectCreated", true);
    modelAndView.setViewName("redirect:/dashboard");
    return modelAndView;
  }

  @RequestMapping(value = "/project/edit/{projectId}", method = RequestMethod.GET)
  public ModelAndView getEditProjectPage(@PathVariable ObjectId projectId) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("project", projectService.getById(projectId));
    modelAndView.setViewName("project/edit");
    return modelAndView;
  }

  @RequestMapping(value = "/project", method = RequestMethod.PUT)
  public ModelAndView updateProject(@Valid Project project) {
    ModelAndView modelAndView = new ModelAndView();
    this.projectService.update(project);
    modelAndView.addObject("projectUpdated", true);
    modelAndView.setViewName("redirect:/dashboard");
    return modelAndView;
  }

  @RequestMapping(value = "/project/delete/{projectId}", method = RequestMethod.GET)
  public ModelAndView getDeleteProjectPage(@PathVariable ObjectId projectId) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("project", projectService.getById(projectId));
    modelAndView.setViewName("project/delete");
    return modelAndView;
  }

  @RequestMapping(value = "/project", method = RequestMethod.DELETE)
  public ModelAndView deleteProject(@Valid Project project) {
    ModelAndView modelAndView = new ModelAndView();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userService.findByEmail(auth.getName());
    this.userService.deleteUserProjectByEmail(user.getEmail(), project.getId());
    this.projectService.delete(project);
    modelAndView.addObject("projectDeleted", true);
    modelAndView.setViewName("redirect:/dashboard");
    return modelAndView;
  }

  @RequestMapping(value = "/project/share/{projectId}", method = RequestMethod.GET)
  public ModelAndView getShareProjectTemplate(@PathVariable ObjectId projectId) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("project", projectService.getById(projectId));
    modelAndView.addObject("users", userService.getAll());
    modelAndView.setViewName("project/share");
    return modelAndView;
  }

  @RequestMapping(value = "/project/share/{projectId}", method = RequestMethod.POST)
  public ModelAndView addUserToProjectSharedList(@PathVariable ObjectId projectId) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("redirect:/project/view/" + projectId);
    return modelAndView;
  }
}
