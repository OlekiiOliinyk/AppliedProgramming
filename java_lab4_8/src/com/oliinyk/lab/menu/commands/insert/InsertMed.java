package com.oliinyk.lab.menu.commands.insert;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.MedicalInsurance;
import com.oliinyk.lab.mail.Email;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class InsertMed implements Insert {

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public void execute(List<BasicInsurance> derevative){

        logger.info("Зчитування медичного страхування з консолі");


        Scanner scanner = new Scanner(System.in);
        InsertMenu insertMenu = new InsertMenu();


        String name = getName(scanner);
        int age = getAge(scanner);
        double risk = insertMenu.getRisk(scanner);
        double expCompens = insertMenu.getExpCompens(scanner);


        initEl(name, age, risk, expCompens, derevative);

        System.out.println("Запис додано...");
    }

    public String getName(Scanner scanner){
        System.out.print("Введіть ПІБ особи: ");
        return scanner.nextLine();
    }


    public int getAge(Scanner scanner){
        int age;
        while (true) {
            try {
                System.out.print("Введіть вік: ");
                age = scanner.nextInt();
                if (age > 0) {
                    return age;
                }
                System.out.println("Від'ємне значення неможливе, спробуйте ще раз");
            }catch(InputMismatchException e){
                logger.severe("Помилка введення даних");
                Email.sendEmailLetter("Помилка введення даних");
                scanner.nextLine();
            }
        }
    }

    public void initEl(String name, int age, double risk, double expCompens, List<BasicInsurance> derevative){

        MedicalInsurance insurance = (MedicalInsurance) MedicalInsurance
                .builder()
                .name(name)
                .age(age)
                .risk(risk)
                .expCompens(expCompens)
                .build();

        derevative.add(insurance);

    }
}
