package com.francesco.progDataBase.business;



import com.francesco.progDataBase.persistence.CaricamentoDati;
import com.francesco.progDataBase.persistence.StudDAO;
import com.francesco.progDataBase.persistence.StudenteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Component
@Service("ServiceStudenteDAO")
public class ServiceStudenteDAO  implements ServiceStudenteDAOInterface{

    @Autowired
   private StudDAO studDAO;
    @Autowired
    private CaricamentoDati caricamentoDati;


    public StudenteEntity addStudenteService(String matricola, String nome, String cognome, String data)
    {
        return studDAO.addNewStudente(matricola,nome, cognome,data);
    }

    @Override
    public Iterable<StudenteEntity> stampaStudenti() {
        return studDAO.getAllStudentInDb();
    }

    public int carica()
    {
        return   caricamentoDati.readFileCsv();
    }

    public long contaRecordStudenti()
    {
        return studDAO.contaRecord();
    }
}
