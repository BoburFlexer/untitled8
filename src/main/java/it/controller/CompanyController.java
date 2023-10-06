package it.controller;

import it.model.Company;
import it.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("c", companyRepository.findAll());
        return "find-all";
    }

    @GetMapping("find/by/{id}")
    public String findById(@PathVariable long id, Model model) {
        model.addAttribute("comp", companyRepository.findById(id));
        return "find-by";
    }
    @GetMapping("save/form")
    public String saveForm(){
        return "save-form";
    }

    @PostMapping ("save")
    public String save(
            @RequestParam("companyName") String companyName,
            @RequestParam("locatedCountry") String locatedCountry
    ) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        companyRepository.save(company);
        return "redirect:/";
    }
    @GetMapping("update/form/{id}")
    public String update(@PathVariable long id, Model model){
        model.addAttribute("up", companyRepository.findById(id));
        return "update-form";

    }

    @PostMapping ("update/{id}")
    public String update(@PathVariable long id, @RequestParam("companyName") String companyName, @RequestParam("locatedCountry") String locatedCountry) {
        Company company = companyRepository.findById(id);
        company.setLocatedCountry(locatedCountry);
        company.setCompanyName(companyName);
        companyRepository.update(company,id);
        return "redirect:/";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable long id){
        companyRepository.delete(id);
        return "redirect:/";
    }
}
