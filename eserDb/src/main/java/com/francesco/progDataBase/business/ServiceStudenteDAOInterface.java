package com.francesco.progDataBase.business;

import com.francesco.progDataBase.persistence.StudenteEntity;
import org.springframework.stereotype.Service;

@Service
public interface ServiceStudenteDAOInterface {

    public StudenteEntity addStudenteService(String matricola, String nome, String cognome, String data);
    public  Iterable<StudenteEntity> stampaStudenti();
    public int carica();
    public long contaRecordStudenti();

}

