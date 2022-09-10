import Arena.*;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {

    public static String createFile(int i){

        String fileName = "resultsFileFight(" + i + ").txt";
        try {
            File myFile = new File(fileName);
            if (myFile.createNewFile()) {
                System.out.println("Файл створено: " + myFile.getName() + "\n");
            } else {
                System.out.println("Файл уже існує.\n");
                myFile.delete();
                myFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Помилка знайдена.\n");
            e.printStackTrace();
        }
        return fileName;
    }

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        int i = 0;

        try {
            while (true) {
                System.out.print("\nСимуляція бою - 1, Вихід - 0: ");
                int n = scanner.nextInt();
                scanner.nextLine();

                if (n == 1) {
                    ArenaNvN teamFight = new ArenaNvN();
                    teamFight.fight(createFile(i + 1));
                }
                else if (n == 0) {
                    System.out.print("До зустрічі, дякую за гру");
                    break;
                }
                else {
                    System.out.println("Не зрозумів команди");
                }
                i++;
            }
            } catch (IOException e) {
                System.out.println("Помилка знайдена.\n");
                e.printStackTrace();
            }
    }

}
