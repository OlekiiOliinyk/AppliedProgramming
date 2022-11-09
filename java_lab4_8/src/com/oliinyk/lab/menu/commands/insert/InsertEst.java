package com.oliinyk.lab.menu.commands.insert;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.EstateInsurance;
import com.oliinyk.lab.mail.Email;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class InsertEst implements Insert{

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    @Override
    public void execute(List<BasicInsurance> derevative) {

        logger.info("Зчитування страхування нерухомості з консолі");

        Scanner scanner = new Scanner(System.in);
        InsertMenu insertMenu = new InsertMenu();


        String location = getLocation(scanner);
        double area = getArea(scanner);
        double risk = insertMenu.getRisk(scanner);
        double expCompens = insertMenu.getExpCompens(scanner);

        initEl(location,area,risk,expCompens,derevative);

        System.out.println("Запис додано...");

    }

    public String getLocation(Scanner scanner){
        System.out.print("Введіть адресу нерухомості: ");
        return scanner.nextLine();
    }

    public double getArea(Scanner scanner){
        double area;
        while (true) {
            try {
                System.out.print("Введіть площу: ");
                area = scanner.nextDouble();
                if (area > 0){
                    return area;
                }
                System.out.println("Від'ємне значення неможливе, спробуйте ще раз");
            }catch(InputMismatchException e){
                logger.severe("Помилка введення даних");
                Email.sendEmailLetter("Помилка введення даних");
                scanner.nextLine();
            }
        }
    }

    public void initEl(String location, double area, double risk, double expCompens,List<BasicInsurance> derevative){

        EstateInsurance insurance = (EstateInsurance) EstateInsurance.builder()
                .location(location)
                .area(area)
                .risk(risk)
                .expCompens(expCompens)
                .build();

        derevative.add(insurance);
    }
}
