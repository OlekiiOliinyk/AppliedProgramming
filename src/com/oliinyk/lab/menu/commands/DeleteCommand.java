package com.oliinyk.lab.menu.commands;

import com.oliinyk.lab.insurance.BasicInsurance;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class DeleteCommand implements Command{

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public void execute(List<BasicInsurance> derevative){

        logger.info("Видалення елементу деривативу");

        Scanner scan = new Scanner(System.in);
        int deleteIndex = getDelIndex(scan);

        System.out.println("Видалені дані: ");
        deleteEl(derevative, deleteIndex);

    }

    public int getDelIndex(Scanner scan){

        System.out.print("Введіть номер зобов'язання для видалення: ");
        return scan.nextInt();
    }

    public void deleteEl(List<BasicInsurance> derevative, int deleteIndex){

        for(int i = 0; i < derevative.size(); i++) {

            BasicInsurance el = derevative.get(i);

            if (i == deleteIndex-1){
                System.out.println(derevative.get(i));
                derevative.remove(i);
            }
        }
    }

    public String getDescription() {
        return"видалення зобов'язання з деривативу";
    }
}
