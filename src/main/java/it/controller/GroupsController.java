package it.controller;

import it.model.Company;
import it.model.Course;
import it.model.Groups;
import it.repository.CompanyRepository;
import it.repository.CourseRepository;
import it.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupsController {
    @Autowired
    private GroupsRepository groupsRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("groups")
    public String findAll(Model model) {
        model.addAttribute("findAllGroups", groupsRepository.findAll());
        return "find-all-groups";
    }

    @GetMapping("find/groups/by/{id}")
    public String findById(@PathVariable long id, Model model) {
        model.addAttribute("findByIdCourse", groupsRepository.findById(id));
        return "find-by-groups";
    }

    @GetMapping("save/groups/form")
    public String saveForm(Model model) {
        model.addAttribute("allCompany", companyRepository.findAll());
        model.addAttribute("allCourse", courseRepository.findAll());
        return "save-form-groups";
    }

    @PostMapping("save/groups")
    public String save(
            @RequestParam("id") long id,
            @RequestParam("course_id") long course_id,
            @RequestParam("dateOfStart") String dateOfStart,
            @RequestParam("dateOfFinish") String dateOfFinish,
            @RequestParam("groupName") String groupName
    ) {
        Groups groups = new Groups();
        Company company = companyRepository.findById(id);
        Course course = courseRepository.findById(course_id);
        groups.setCompany(company);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        groups.setCourses(courses);
        groups.setDateOfStart(dateOfStart);
        groups.setDateOfFinish(dateOfFinish);
        groups.setGroupName(groupName);
        groupsRepository.save(groups);
        return "redirect:/groups";
    }

    @GetMapping("update/groups/form/{id}")
    public String update(@PathVariable long id, Model model) {
        model.addAttribute("updateGroups", groupsRepository.findById(id));
        return "update-form-groups";
    }

    @PostMapping("update/groups/{id}")
    public String update(@PathVariable long id,
                         @RequestParam("dateOfStart") String dateOfStart,
                         @RequestParam("dateOfFinish") String dateOfFinish,
                         @RequestParam("groupName") String groupName) {
        Groups groups = groupsRepository.findById(id);
        groups.setDateOfStart(dateOfStart);
        groups.setDateOfFinish(dateOfFinish);
        groups.setGroupName(groupName);
        groupsRepository.update(groups, id);
        return "redirect:/groups";
    }

    @GetMapping("delete/groups/{id}")
    public String delete(@PathVariable long id) {
        groupsRepository.delete(id);
        return "redirect:/groups";
    }
}
