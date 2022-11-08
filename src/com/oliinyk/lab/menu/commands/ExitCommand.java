package com.oliinyk.lab.menu.commands;

import com.oliinyk.lab.insurance.BasicInsurance;

import java.util.List;
import java.util.logging.Logger;

public class ExitCommand implements Command{

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public void execute(List<BasicInsurance> derevative){

        logger.info("Вихід з програми");
        System.out.println("Вихід з програми...");
        System.exit(0);
    }
    public String getDescription() {
        return "вихід з програми";
    }
}
