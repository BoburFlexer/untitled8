package it.controller;

import it.model.Company;
import it.model.Course;
import it.repository.CompanyRepository;
import it.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("course")
    public String findAll(Model model) {
        model.addAttribute("findAllCourse", courseRepository.findAll());
        return "find-all-course";
    }

    @GetMapping("find/course/by/{id}")
    public String findById(@PathVariable long id, Model model) {
        model.addAttribute("findByIdCourse", courseRepository.findById(id));
        return "find-by";
    }

    @GetMapping("save/course/form")
    public String saveForm(Model model) {
        model.addAttribute("all", companyRepository.findAll());
        return "save-form-course";

    }

    @PostMapping("save/course")
    public String save(
            @RequestParam("id") long id,
            @RequestParam("courseName") String courseName,
            @RequestParam("duration") String duration
    ) {
        Course course = new Course();
        Company company = companyRepository.findById(id);
        course.setCompany(company);
        course.setCourseName(courseName);
        course.setDuration(duration);
        courseRepository.save(course);
        return "redirect:/course";
    }

    @GetMapping("update/course/form/{id}")
    public String update(@PathVariable long id, Model model) {
        model.addAttribute("updateCourse", courseRepository.findById(id));
        return "update-form-course";
    }

    @PostMapping("update/course/{id}")
    public String update(@PathVariable long id, @RequestParam("courseName") String courseName, @RequestParam("duration") String duration) {
        Course course = courseRepository.findById(id);
        course.setCourseName(courseName);
        course.setDuration(duration);
        courseRepository.update(course, id);
        return "redirect:/course";
    }

    @GetMapping("delete/course/{id}")
    public String delete(@PathVariable long id) {
        courseRepository.delete(id);
        return "redirect:/course";
    }
}


