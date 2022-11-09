package com.oliinyk.lab.menu.commands.insert;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.mail.Email;

import java.util.*;
import java.util.logging.Logger;

public class InsertMenu {

    private Map<String, Insert> types;

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public InsertMenu(){
        types = new HashMap<>();
        types.put("car",             new InsertCar());
        types.put("medical",         new InsertMed());
        types.put("estate",          new InsertEst());

    }

    public void execute(String command, List<BasicInsurance> derevative) {
        types.getOrDefault(command, (List<BasicInsurance> error) ->
                System.out.println("Некоректні дані")).execute(derevative);
    }

    public Set<String> getTypes(){
         return types.keySet();
    }


    public double getRisk(Scanner scanner){
        double risk;
        while (true){
            try {
                System.out.print("Введіть ризик у відсотках: ");
                risk = scanner.nextDouble();
                if(risk>0 && risk < 100){
                    return risk;
                }
                System.out.println("Від'ємне значення неможливе, спробуйте ще раз");
            }catch(InputMismatchException e){
                logger.severe("Помилка введення даних");
                Email.sendEmailLetter("Помилка введення даних");
                scanner.nextLine();
            }
        }
    }

    public double getExpCompens(Scanner scanner){

        double expCompens;


        while (true) {

            System.out.print("Введіть суму очікуваної компенсації: ");

            try{
                expCompens = scanner.nextDouble();
                if (expCompens > 0) {
                    return expCompens;
                }
                System.out.println("Від'ємне значення неможливе, спробуйте ще раз");
            }catch(InputMismatchException e){
                logger.severe("Помилка введення даних");
                Email.sendEmailLetter("Помилка введення даних");
                scanner.nextLine();
            }
        }
    }
}
