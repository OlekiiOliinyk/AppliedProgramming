package com.oliinyk.lab.menu.commands;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.menu.commands.scan.ScanMenu;
import com.oliinyk.lab.mail.Email;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ReadfileCommand implements Command {

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public void execute(List<BasicInsurance> derevative) {

        logger.info("Початок сканування деривативних даних з файлу");

        Scanner scanner = new Scanner(System.in);

        try{

            String filePath = getFilePath(scanner);
            File file = new File(filePath);
            Scanner fileScan = new Scanner(file);

            scanFileInfo(derevative, fileScan);

            logger.info("Кінець сканування деривативних даних з файлу");

            System.out.println("Дані скопійовано з файлу");
            fileScan.close();
        }
        catch (IOException ex) {

            logger.severe("Неправильний шлях до файлу");
            Email.sendEmailLetter("Неправильний шлях до файлу");

        }
    }

    public String getFilePath(Scanner scanner){

        System.out.print("Введіть повний шлях до файлу: ");
        return scanner.nextLine().trim();

    }


    public void scanFileInfo(List<BasicInsurance> derevative, Scanner fileScan){

        String type;
        ScanMenu scanMenu = new ScanMenu();
        while (fileScan.hasNext()){

            type = findType(fileScan);

            scanMenu.execute(type, derevative, fileScan);

        }
    }

    public String findType(Scanner fileScan ){

        String type;
        do {
            type = fileScan.nextLine();
        }while (type.equalsIgnoreCase(""));

        return type;
    }

    public String getDescription() {
        return"зчитування деривативу з txt-файлу";
    }
}
