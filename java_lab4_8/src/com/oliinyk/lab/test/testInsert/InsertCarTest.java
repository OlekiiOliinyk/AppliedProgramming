package com.oliinyk.lab.test.testInsert;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.CarInsurance;
import com.oliinyk.lab.menu.commands.insert.InsertCar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertCarTest {

    @Test
    void insertCarTest(){

        List<BasicInsurance> derevative1 = new ArrayList<>(1);

        CarInsurance insurance1 = (CarInsurance) CarInsurance
                .builder()
                .model("Tesla")
                .kmrun(20000)
                .risk(1.2)
                .expCompens(500000)
                .build();

        derevative1.add(insurance1);

        List<BasicInsurance> derevative2 = new ArrayList<>(1);

        InsertCar insertCar = new InsertCar();

        insertCar.initEl("Tesla", 20000,1.2,500000,derevative2);

        assertEquals(derevative1.get(0).toString(),derevative2.get(0).toString());

    }

}