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
	CommandLineRunner start(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(new Patient(null,"Ahmed","Youness", LocalDate.of(1994,2,16),"TVZ","47454951","Ah148@gmail.com"));
			patientRepository.save(new Patient(null,"Mouna","Moctar", LocalDate.of(2002,8,5),"Arafat","22261178","Mouna@yahoo.fr"));
			patientRepository.save(new Patient(null,"Zeinebou","Moctar", LocalDate.of(1999,10,12),"Toujounine","36471512","Km92s@gmail.com"));
			patientRepository.save(new Patient(null,"Mata","Mahfoudh", LocalDate.of(2000,6,23),"Teyaret","46550665","Tita.ens@gmail.com"));
			patientRepository.save(new Patient(null,"Yacoub","Chiko", LocalDate.of(1997,2,1),"El Mina","23211745","Yacoubs14@yahoo.fr"));
			patientRepository.save(new Patient(null,"Moctar","Mohamed Salem", LocalDate.of(1995,6,16),"Skouk","36181417","Med14.sen@gmail.com"));
			patientRepository.save(new Patient(null,"Cheikhna","Med Lemine", LocalDate.of(2000,8,8),"Sebkha","47486225","Cheks@outlook.com"));
			patientRepository.save(new Patient(null,"Mariem","Bouna", LocalDate.of(2002,1,31),"Riyad","22303019","Nana@yahoo.fr"));
			patientRepository.save(new Patient(null,"Youssef","Babana", LocalDate.of(1993,2,10),"Dar naim","42191717","Jossef45@gmail.com"));
		};


	}

}
