package com.oliinyk.lab.menu.commands;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.menu.Menu;

import java.util.List;
import java.util.logging.Logger;

public class HelpCommand implements Command{

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public void execute(List<BasicInsurance> derevative){

        logger.info("Відкриття хелпу команд");

        Menu menu = new Menu();
        menu.printCommands();

    }

    public String getDescription() {
        return"список команд";
    }

}
