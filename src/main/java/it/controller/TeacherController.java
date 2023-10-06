package it.controller;

import it.model.Company;
import it.model.Course;
import it.model.Teacher;
import it.repository.CourseRepository;
import it.repository.TeacherRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("teacher")
    public String findAll(Model model) {
        model.addAttribute("findAllTeacher", teacherRepository.findAll());
        return "find-all-teacher";
    }

    @GetMapping("find/teacher/by/{id}")
    public String findById(@PathVariable long id, Model model) {
        model.addAttribute("findByIdTeacher", teacherRepository.findById(id));
        return "find-by-teacher";
    }

    @GetMapping("save/teacher/form")
    public String saveForm(Model model) {
        model.addAttribute("all", courseRepository.findAll());
        return "save-form-teacher";
    }

    @PostMapping("save/teacher")
    public String save(
            @RequestParam("id") long id,
            @RequestParam("email") String email,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        Course course = courseRepository.findById(id);
        Teacher teacher = new Teacher();
        teacher.setCourse(course);
        teacher.setEmail(email);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacherRepository.save(teacher);
        return "redirect:/teacher";
    }

    @GetMapping("update/teacher/form/{id}")
    public String update(@PathVariable long id, Model model) {
        model.addAttribute("teacher", teacherRepository.findById(id));
        return "update-form-teacher";
    }

    @PostMapping("update/teacher/{id}")
    public String update(@PathVariable long id,
                         @RequestParam("email") String email,
                         @RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        Teacher teacher = teacherRepository.findById(id);
        teacher.setEmail(email);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacherRepository.update(teacher, id);
        return "redirect:/teacher";
    }
    @GetMapping("delete/teacher/{id}")
    public String delete(@PathVariable long id) {
        teacherRepository.delete(id);
        return "redirect:/teacher";
    }
}
