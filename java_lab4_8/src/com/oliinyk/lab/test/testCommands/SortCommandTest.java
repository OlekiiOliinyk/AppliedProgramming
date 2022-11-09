package com.oliinyk.lab.test.testCommands;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.CarInsurance;
import com.oliinyk.lab.menu.commands.SortCommand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortCommandTest {

    @Test
    void sortTest() {

        SortCommand sortCommand = new SortCommand();


        List<BasicInsurance> derevative1 = new ArrayList<>(10);

        CarInsurance insurance1 = (CarInsurance) CarInsurance
                .builder()
                .model("Tesla1")
                .kmrun(20000)
                .risk(10)
                .expCompens(500000)
                .build();

        derevative1.add(insurance1);

        CarInsurance insurance2 = (CarInsurance) CarInsurance
                .builder()
                .model("Tesla2")
                .kmrun(20000)
                .risk(1)
                .expCompens(500000)
                .build();

        derevative1.add(insurance2);


        List<BasicInsurance> derevative2 = new ArrayList<>(10);

        CarInsurance insurance3 = (CarInsurance) CarInsurance
                .builder()
                .model("Tesla2")
                .kmrun(20000)
                .risk(1)
                .expCompens(500000)
                .build();

        derevative2.add(insurance3);

        CarInsurance insurance4 = (CarInsurance) CarInsurance
                .builder()
                .model("Tesla1")
                .kmrun(20000)
                .risk(10)
                .expCompens(500000)
                .build();

        derevative2.add(insurance4);

        sortCommand.sortDerevative(derevative2);

        assertEquals(derevative1.get(0).toString(),derevative2.get(0).toString());
        assertEquals(derevative1.get(1).toString(),derevative2.get(1).toString());
    }
}