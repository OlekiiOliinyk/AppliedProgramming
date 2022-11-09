package com.oliinyk.lab.menu.commands.insert;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.CarInsurance;
import com.oliinyk.lab.mail.Email;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class InsertCar implements Insert{

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    @Override
    public void execute(List<BasicInsurance> derevative) {

        logger.info("Зчитування автострахування з консолі");

        Scanner scanner = new Scanner(System.in);
        InsertMenu insertMenu = new InsertMenu();

        String model = getModel(scanner);
        double kmrun = getKmrun(scanner);
        double risk = insertMenu.getRisk(scanner);
        double expCompens = insertMenu.getExpCompens(scanner);

        initEl(model, kmrun, risk, expCompens, derevative);

        System.out.println("Запис додано...");
    }

    public String getModel(Scanner scanner){

        System.out.print("Введіть модель машини: ");
        return scanner.nextLine();
    }

    public double getKmrun(Scanner scanner){
        double kmrun;
        while (true){
            try {
                System.out.print("Введіть пробіг у км: ");
                kmrun = scanner.nextDouble();
                if(kmrun>0){
                    return kmrun;
                }
                System.out.println("Від'ємне значення неможливе, спробуйте ще раз");
            }catch(InputMismatchException e){
                logger.severe("Помилка введення даних");
                Email.sendEmailLetter("Помилка введення даних");
                scanner.nextLine();
            }
        }
    }

    public void initEl(String model,double kmrun,double risk,double expCompens, List<BasicInsurance> derevative){

        CarInsurance insurance = (CarInsurance) CarInsurance
                .builder()
                .model(model)
                .kmrun(kmrun)
                .risk(risk)
                .expCompens(expCompens)
                .build();


        derevative.add(insurance);
    }

}
