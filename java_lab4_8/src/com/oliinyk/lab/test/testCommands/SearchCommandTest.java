package com.oliinyk.lab.test.testCommands;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.CarInsurance;
import com.oliinyk.lab.insurance.EstateInsurance;
import com.oliinyk.lab.menu.commands.SearchCommand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchCommandTest {

    @Test
    void searchTest(){

        SearchCommand searchCommand = new SearchCommand();

        List<BasicInsurance> derevative = new ArrayList<>(10);

        CarInsurance insurance1 = (CarInsurance) CarInsurance
                .builder()
                .model("Tesla1")
                .kmrun(20000)
                .risk(10)
                .expCompens(500000)
                .build();

        derevative.add(insurance1);

        CarInsurance insurance2 = (CarInsurance) CarInsurance
                .builder()
                .model("Tesla2")
                .kmrun(20000)
                .risk(1)
                .expCompens(500000)
                .build();

        derevative.add(insurance2);

        EstateInsurance insurance3 = (EstateInsurance) EstateInsurance.builder()
                .location("lviv")
                .area(58)
                .risk(5)
                .expCompens(300000)
                .build();

        derevative.add(insurance3);


        assertEquals(insurance2.toString(), searchCommand.find(derevative, 1).get(0).toString());

    }
}