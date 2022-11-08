package com.oliinyk.lab.menu.commands;

import com.oliinyk.lab.insurance.BasicInsurance;



import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class SortCommand implements Command {

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public void execute(List<BasicInsurance> derevative){
        logger.info("Сортування деривативу");
        sortDerevative(derevative);
    }

    public void sortDerevative(List<BasicInsurance> derevative){

        derevative.sort((x, y) -> Double.compare(y.getRisk(), x.getRisk()));

        System.out.println("Дериватив відсортований\n");
    }

    public String getDescription() {
        return"сортування деривативу";
    }
}
