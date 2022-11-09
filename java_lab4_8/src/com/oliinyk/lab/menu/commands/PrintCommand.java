package com.oliinyk.lab.menu.commands;

import com.oliinyk.lab.insurance.BasicInsurance;

import java.util.List;
import java.util.logging.Logger;

public class PrintCommand implements Command {

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public void execute(List<BasicInsurance> derevative){

        logger.info("Виведення деривативу на екран");

        printInfo(derevative);

    }


    public void printInfo(List<BasicInsurance> derevative){
        System.out.println("\nДериватив:");

        for(int i = 0; i < derevative.size(); i++) {
            System.out.print(i+1 + ". ");
            System.out.println(derevative.get(i));
        }
    }

    public String getDescription() {
        return "виведення деривативу";
    }
}
