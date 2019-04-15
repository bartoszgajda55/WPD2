package com.gcu.wpd2.controllers;

import com.gcu.wpd2.services.MilestoneService;
import com.gcu.wpd2.services.ProjectService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

}
