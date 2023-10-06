package it.controller;

import it.model.Company;
import it.model.Course;
import it.model.Groups;
import it.model.Student;
import it.repository.GroupsRepository;
import it.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    private GroupsRepository groupsRepository;
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("student")
    public String findAll(Model model) {
        model.addAttribute("findAllGroups", studentRepository.findAll());
        return "find-all-student";
    }
    @GetMapping("find/student/by/{id}")
    public String findById(@PathVariable long id, Model model) {
        model.addAttribute("findByIdCourse", studentRepository.findById(id));
        return "find-by-student";
    }
    @GetMapping("save/student/form")
    public String saveForm(Model model) {
        model.addAttribute("allStudent", groupsRepository.findAll());
        return "save-form-student";
    }
    @PostMapping("save/student")
    public String save(
            @RequestParam("id") long id,
            @RequestParam("email") String email,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        Student student = new Student();
        Groups groups = groupsRepository.findById(id);
        student.setGroups(groups);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        studentRepository.save(student);
        return "redirect:/student";
    }
    @GetMapping("update/student/form/{id}")
    public String update(@PathVariable long id, Model model) {
        model.addAttribute("updateCourse", studentRepository.findById(id));
        return "update-form-student";
    }
    @PostMapping("update/student/{id}")
    public String update(@PathVariable long id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam ("email") String email) {
        Student student = studentRepository.findById(id);
        student.setEmail(email);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentRepository.update(student,id);
        return "redirect:/student";
    }
    @GetMapping("delete/student/{id}")
    public String delete(@PathVariable long id) {
        studentRepository.delete(id);
        return "redirect:/student";
    }
}
