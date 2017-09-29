package com.francesco.progDataBase;

import com.francesco.progDataBase.business.ServiceStudenteDAO;
import com.francesco.progDataBase.persistence.StudenteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgDataBaseApplication implements CommandLineRunner {


	@Autowired
	ServiceStudenteDAO serviceStudenteDAO;

	public static void main(String[] args) {
		SpringApplication.run(ProgDataBaseApplication.class, args);

	}

    @Override
	public void run(String... args) throws Exception {

		//caricamento da file
		int numCampi=serviceStudenteDAO.carica();

		//stampa
		System.out.println("matricola studenti  in DB dopo aver inserito i campi presenti nel file");

		for (StudenteEntity student : serviceStudenteDAO.stampaStudenti()) {
			System.out.println(student.getMatricola());
		}

		//numero Record Studenti nel database
		long  numRecordStudenti=serviceStudenteDAO.contaRecordStudenti();
		System.out.println(numRecordStudenti);
	}



}