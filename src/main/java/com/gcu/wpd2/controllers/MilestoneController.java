package com.gcu.wpd2.controllers;

import com.gcu.wpd2.models.Milestone;
import com.gcu.wpd2.models.Project;
import com.gcu.wpd2.models.User;
import com.gcu.wpd2.services.MilestoneService;
import com.gcu.wpd2.services.ProjectService;
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
public class MilestoneController {

    @Autowired
    private MilestoneService milestoneService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/milestone/view/{milestoneId}", method = RequestMethod.GET)
    public ModelAndView getProjectDetailsPage(@PathVariable ObjectId milestoneId) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("milestone",milestoneService.getByID(milestoneId));
        modelAndView.setViewName("project/view");
        return  modelAndView;
    }
    @RequestMapping(value = "/milestone/create", method = RequestMethod.GET)
    public ModelAndView getCreateMilestonePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(new Milestone());
        modelAndView.setViewName("milestone/create");
        return modelAndView;
    }

    @RequestMapping(value = "/milestone/add", method = RequestMethod.POST)
    public ModelAndView createMilestone(@Valid Milestone milestone, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Project project = projectService.getByName(auth.getName());
        milestoneService.saveToProject(milestone, project);
        return modelAndView;
    }

}
