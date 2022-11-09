package com.oliinyk.lab.test.testCommands;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.CarInsurance;
import com.oliinyk.lab.menu.commands.DeleteCommand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCommandTest {

    @org.junit.jupiter.api.Test
    void emptyListTest() {

        List<BasicInsurance> derevative = new ArrayList<>(10);

        CarInsurance insurance1 = (CarInsurance) CarInsurance
                .builder()
                .model("Tesla")
                .kmrun(20000)
                .risk(1)
                .expCompens(500000)
                .build();
        derevative.add(insurance1);

        DeleteCommand delete = new DeleteCommand();
        delete.deleteEl(derevative,1);

        assertTrue(derevative.isEmpty());

    }
}