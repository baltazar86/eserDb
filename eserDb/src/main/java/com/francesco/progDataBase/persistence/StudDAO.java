package com.francesco.progDataBase.persistence;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class StudDAO   {

    @Autowired
    private StudenteRepo studenteRepository;


    public   StudenteEntity addNewStudente ( String matricola,  String nome,  String cognome,  String data) {

        StudenteEntity stud = new StudenteEntity ();
        stud.setNome (nome);
        stud.setCognome (cognome);
        stud.setMatricola (matricola);
        stud.setData (data);


        return studenteRepository.save (stud);
    }

    public  Iterable<StudenteEntity> getAllStudentInDb() {

        return  studenteRepository.findAll();
    }


    public long contaRecord()
    {
        return studenteRepository.count();
    }

}
