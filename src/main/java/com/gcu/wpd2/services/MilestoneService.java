package com.gcu.wpd2.services;

import com.gcu.wpd2.db.MilestoneRepository;
import com.gcu.wpd2.models.Milestone;
import com.gcu.wpd2.models.Project;
import com.gcu.wpd2.models.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MilestoneService {

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private ProjectService projectService;

    public List<Milestone> getAll() {return milestoneRepository.findAll();}

    public Milestone getByID(ObjectId id) {return this.milestoneRepository.findById(id);}

    public Milestone getByName(String title){ return this.milestoneRepository.findByTitle(title);}

    public void saveToProject(Milestone milestone, Project project){
        this.milestoneRepository.save(milestone);
        project.addMilestones(milestone);
        projectService.save(project);
    }








}
