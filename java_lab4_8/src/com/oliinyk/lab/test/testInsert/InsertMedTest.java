package com.oliinyk.lab.test.testInsert;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.MedicalInsurance;
import com.oliinyk.lab.menu.commands.insert.InsertMed;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertMedTest {

    @Test
    void insertMedTest(){

        InsertMed insertMed = new InsertMed();

        List<BasicInsurance> derevative1 = new ArrayList<>(1);
        List<BasicInsurance> derevative2 = new ArrayList<>(1);


        MedicalInsurance insurance1 = (MedicalInsurance) MedicalInsurance
                .builder()
                .name("Alex")
                .age(19)
                .expCompens(40000)
                .risk(1)
                .build();

        derevative1.add(insurance1);

        insertMed.initEl("Alex", 19,  1, 40000, derevative2);

        assertEquals(derevative1.get(0).toString(),derevative2.get(0).toString());

    }
}