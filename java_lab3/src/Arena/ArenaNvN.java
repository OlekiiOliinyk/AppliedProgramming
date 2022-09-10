package Arena;

import Droid.*;

import java.io.PrintStream;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class ArenaNvN {

    private String team1Name;
    private String team2Name;
    private BaseDroid[] team1;
    private BaseDroid[] team2;

    public BaseDroid createWarriors(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Виберіть клас бійця (1 - Лицар, 2 - Асасин, 3 - Медик, 4 - Танк): ");
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number == 1) {
                return new DroidKnight();
            }
            else if (number == 2) {
                return new DroidAssasin();
            }
            else if (number == 3) {
                return new DroidHealer();
            }
            else if (number == 4) {
                return new DroidTank();
            }
            else {
                System.out.println("Такого класу не існує");
            }
        }
    }
    public int findNumsMembers(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість бійців в командах: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    public void initFighters(BaseDroid[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = createWarriors();
            arr[i].scanInfo();
        }
    }
    public boolean checkTeam(BaseDroid[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].isAlive()){
                return true;
            }
        }
        return false;
    }
    public void printTeam(BaseDroid[] arr, String teamname){
        System.out.println("\nКоманда " + teamname + " : ");
        for (int i = 0; i < arr.length; i++){
            if(arr[i].isAlive()){
                System.out.println(arr[i]);
            }
            else{
                System.out.println(arr[i].getName()+" знищений!");
            }

        }
    }
    public void teamMove(BaseDroid[] allyArr, BaseDroid[] enemyArr){
        for(int i = 0; i < allyArr.length; i++){
            if(allyArr[i].isAlive()) {
                allyArr[i].move(allyArr, enemyArr);
                if(!checkTeam(enemyArr)){
                    return;
                }
            }
        }
    }
    public void printResultsRound(BaseDroid[] team1, BaseDroid[] team2, int n){
        System.out.println("\nРезультат раунду #" + (n+1));
        printTeam(team1, team1Name);
        printTeam(team2, team1Name);
    }

    public void initTeams(){

        Scanner scanner = new Scanner(System.in);

        int count = findNumsMembers();
        team1 = new BaseDroid[count];
        team2 = new BaseDroid[count];

        System.out.print("\nВведіть назву команди: ");
        setTeam1Name(scanner.nextLine());
        initFighters(team1);

        System.out.print("\nВведіть назву команди: ");
        setTeam2Name(scanner.nextLine());
        initFighters(team2);
    }

    private void printFile(String fileName){
        try{
            byte[] content =  Files.readAllBytes(Paths.get(fileName));
            System.out.println(new String(content));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void fight( String fileName )throws FileNotFoundException{

        initTeams();

        PrintStream old = System.out;
        System.setOut(new PrintStream(fileName));

        System.out.println("\n\nКоманди бійців:");
        printTeam(team1, team1Name);
        printTeam(team2, team2Name);

        int n = 0;
        while(true){
            System.out.println("\nРаунд #" + (n+1) + "... В бій!");

            teamMove(team1, team2);
            if(!checkTeam(team2)){
                System.out.println("Команда " + getTeam1Name() + " перемогла!");
                System.out.println("Команда " + getTeam2Name() + " знищена!\n");
                break;
            }

            teamMove(team2, team1);
            if(!checkTeam(team1)){
                System.out.println("Команда " + getTeam2Name() + " перемогла!");
                System.out.println("Команда " + getTeam1Name() + " знищена!\n");
                break;
            }

            printResultsRound(team1, team2, n);
            n++;
        }
       System.out.flush();
       System.setOut(old);
       printFile(fileName);
       System.out.println("\nРезультати бою записані в файл " + fileName + "\n");
    }

    public String getTeam2Name() {return team2Name;}
    public String getTeam1Name() {return team1Name;}
    public void setTeam1Name(String team1Name) {this.team1Name = team1Name;}
    public void setTeam2Name(String team2Name) {this.team2Name = team2Name;}
}

