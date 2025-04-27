package com.tp.demo.controller;
import com.tp.demo.entities.Patient;
import com.tp.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "index";
    }

    @GetMapping("/ajouter")
    public String Ajouter(Model model){
        model.addAttribute("patient", new Patient());
        return "formPatient";
    }

    @PostMapping("/save")
    public String enregistrer(@ModelAttribute Patient p){
        patientRepository.save(p);
        return "redirect:/";
    }
}
