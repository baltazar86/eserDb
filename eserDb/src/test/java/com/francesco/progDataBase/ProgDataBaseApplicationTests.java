package com.francesco.progDataBase;

import com.francesco.progDataBase.business.ServiceStudenteDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgDataBaseApplicationTests {

	@Autowired
	ServiceStudenteDAO serviceStudenteDAO;

	@Test
	public void contextLoads() {
	}

	@Test
	public void  testNumeroCampiLettiESalvatinDb()
	{

	    int numRecordInFile=serviceStudenteDAO.carica();
	    System.out.println("sono nel testing e il numero di righe è "+ numRecordInFile);
			Assert.assertEquals(3,numRecordInFile);

	}

	@Test
    public void testContaRecordInDb()
    {
        long numRecordInDb=serviceStudenteDAO.contaRecordStudenti();
        Assert.assertEquals(4,numRecordInDb);
    }


}
