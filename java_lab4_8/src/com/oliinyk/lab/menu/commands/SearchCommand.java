package com.oliinyk.lab.menu.commands;

import com.oliinyk.lab.insurance.BasicInsurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class SearchCommand implements Command {

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public void execute(List<BasicInsurance> derevative){

        logger.info("Пошук страхового зобов'язання");

        List<String> foundInsurance;

        double searchedRisk = getSearchedRisk();

        foundInsurance = find(derevative, searchedRisk);

        printFound(foundInsurance);
    }

    public double getSearchedRisk(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Для пошуку страхових зобов'зань введіть ризик у відсотках: ");
        return scan.nextDouble();
    }

    public void printFound(List<String> foundInsurance){
        for(String el : foundInsurance){
            System.out.println(el);
        }
    }

    public List<String> find(List<BasicInsurance> derevative, double searchedRisk){

        List<String> insuranceArr = new ArrayList<>(10);

        for (BasicInsurance el : derevative) {

            if (el.getRisk() == searchedRisk) {
                insuranceArr.add(el.toString());
            }
        }

        return insuranceArr;
    }

    public String getDescription() {
        return"пошук зобов'язань в деривативі";
    }
}
