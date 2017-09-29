package com.francesco.progDataBase.persistence;


import com.francesco.progDataBase.business.ServiceStudenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Component
public class CaricamentoDati {


@Autowired
private ServiceStudenteDAO serviceStudenteDAO;



  static final  String csvFile = "../progDataBase/src/main/resources/studente.csv";

    static  String line = "";
    static final String cvsSplitBy = ",";
    private int contaRighe = 0;

    public static String getCsvFile() {
        return csvFile;
    }

    public static String getLine() {
        return line;
    }

    public static void setLine(String line) {
        CaricamentoDati.line = line;
    }

    public static String getCvsSplitBy() {
        return cvsSplitBy;
    }

    public int getContaRighe() {
        return contaRighe;
    }

    public void setContaRighe(int contaRighe) {
        this.contaRighe = contaRighe;
    }

    public  int readFileCsv() {
        contaRighe=0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
              String[] campo = line.split(cvsSplitBy);
                //studDAO.addNewStudente(campo[0].replace('"','\u0000'),campo[1].replace('"','\u0000'),campo[2].replace('"','\u0000'),campo[3].replace('"','\u0000'));
                    serviceStudenteDAO.addStudenteService(campo[0].replace('"', ' '), campo[1].replace('"', ' '), campo[2].replace('"', ' '), campo[3].replace('"', ' '));
                    contaRighe++;
                    System.out.println("\nriga "+ contaRighe+"\n");


                for(String cmp:campo)
                {
                    System.out.println(cmp);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    return contaRighe;
    }
}