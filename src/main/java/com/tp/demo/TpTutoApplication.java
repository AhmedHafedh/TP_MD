package com.tp.demo;

import com.tp.demo.entities.Patient;
import com.tp.demo.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TpTutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpTutoApplication.class, args);
	}

	@Bean
	CommandLineRunner startdb(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(new Patient(null,"Ahmed","Khatary", LocalDate.now(),"Toujounine"
			,"421874546","Kh14s@gmail.com"));
			patientRepository.save(new Patient(null,"Mariem","Ghazouni", LocalDate.now(),"TVZ"
					,"30595117","GHz.12@yahoo.fr"));
			patientRepository.save(new Patient(null,"Zeinebou","Ba", LocalDate.now(),"El Mina"
					,"22411516","Kh14s@outlook.com"));
			patientRepository.save(new Patient(null,"Salem","Moctar", LocalDate.now(),"Teyaret"
					,"34171214","S2025.dh@gmail.com"));
		};
	}
}
