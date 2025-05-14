package com.tp.demo.controller;
import com.tp.demo.entities.Patient;
import com.tp.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/")
    public String accueil(){
        return "redirect:/patients";
    }
    @GetMapping("/patients")
    public String index(Model model, @RequestParam(name="page", defaultValue = "0") int page,
                        @RequestParam(name="size", defaultValue = "3") int size){
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("patients",patients);
        model.addAttribute("currentpage", page);
        model.addAttribute("size", size);
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        return "index";
    }
    @GetMapping("/Ajouter")
    public String ajouter(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Patient patient){
        patientRepository.save(patient);
        return "redirect:/";
    }
    @GetMapping("/modifier/{id}")
    public String update(@PathVariable Long id, Model model){
        model.addAttribute("patient", patientRepository.findById(id).get());
        return "formPatient.html";
    }

    @GetMapping("/supprimer/{id}")
    public String delete(@PathVariable Long id){
        patientRepository.deleteById(id);
        return "redirect:/";
    }

}
