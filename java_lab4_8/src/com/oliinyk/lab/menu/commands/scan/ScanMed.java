package com.oliinyk.lab.menu.commands.scan;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.MedicalInsurance;
import com.oliinyk.lab.mail.Email;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ScanMed implements Scan{

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public void execute(List<BasicInsurance> derevative, Scanner fileScan){

        logger.info("Сканування медичного страхування");

        scan(derevative,fileScan);


        System.out.println("Запис додано...");
    }


    public void scan(List<BasicInsurance> derevative, Scanner fileScan){

        try {

            MedicalInsurance insurance = (MedicalInsurance) MedicalInsurance
                    .builder()
                    .name(fileScan.nextLine())
                    .age(fileScan.nextInt())
                    .risk(fileScan.nextDouble())
                    .expCompens(fileScan.nextDouble())
                    .build();
                derevative.add(insurance);

        }catch (InputMismatchException e){
            logger.severe("Помилка зчитування даних з файлу");
            Email.sendEmailLetter("Помилка зчитування даних з файлу");
        }

    }
}
