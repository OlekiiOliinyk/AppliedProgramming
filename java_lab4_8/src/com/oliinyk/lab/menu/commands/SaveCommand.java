package com.oliinyk.lab.menu.commands;
import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.mail.Email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class SaveCommand implements Command {

    private static final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    public void execute(List<BasicInsurance> derevative){

        logger.info("Збереження деривативу в файл");

        Scanner scanner = new Scanner(System.in);

        String fileDirectory = getFileDirectory(scanner);

        String fileName = getFileName(scanner);

        String filePath = createFilePath(fileDirectory, fileName);

        saveFile(derevative, filePath);

    }

    public String getFileDirectory(Scanner scanner){

        System.out.print("Введіть шлях до директорії файлу:");
        return scanner.nextLine().trim() + "\\";
    }

    public String getFileName(Scanner scanner){

        System.out.print("Введіть назву файлу:");
        return scanner.nextLine().trim();
    }

    public String createFilePath(String fileDirectory, String fileName){

        System.out.println("Місцезнаходження файлу: "+fileDirectory+fileName);
        return  fileDirectory+fileName;

    }

    public void saveFile(List<BasicInsurance> derevative, String filePath){

        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println("Дериватив:");

            for(int i = 0; i < derevative.size(); i++) {
                out.print(i+1 + ". ");
                out.println(derevative.get(i));
            }
        }catch (IOException e) {
            logger.severe("Помилка збереження в файл");
            Email.sendEmailLetter("Помилка збереження в файл");
        }
    }

    public String getDescription() {
        return"збереження даних в файл";
    }
}
