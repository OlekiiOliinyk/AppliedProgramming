package com.oliinyk.lab;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.mail.Email;
import com.oliinyk.lab.menu.Menu;
import com.oliinyk.lab.logger.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args){

        List<BasicInsurance> derevative = new ArrayList<>(10);
        String command;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        MyLogger.setupLogger();

        logger.info("Запуск програми");

        System.out.println("'help' виведення всіх команд");

        while(true){
            System.out.print("Введіть команду: ");
            command = scanner.nextLine();
            command = command.trim();
            menu.execute(command, derevative);
        }
    }
}