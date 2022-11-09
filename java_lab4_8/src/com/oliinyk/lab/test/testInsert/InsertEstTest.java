package com.oliinyk.lab.test.testInsert;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.EstateInsurance;
import com.oliinyk.lab.menu.commands.insert.InsertEst;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertEstTest {

    @Test
    void insertEstTest(){

        InsertEst insertEst = new InsertEst();

        List<BasicInsurance> derevative1 = new ArrayList<>(1);


        EstateInsurance insurance1 = (EstateInsurance) EstateInsurance.builder()
                .location("lviv")
                .area(58)
                .risk(5)
                .expCompens(300000)
                .build();

        derevative1.add(insurance1);

        List<BasicInsurance> derevative2 = new ArrayList<>(1);

        insertEst.initEl("lviv", 58, 5, 300000, derevative2);

        assertEquals(derevative1.get(0).toString(),derevative2.get(0).toString());

    }
}