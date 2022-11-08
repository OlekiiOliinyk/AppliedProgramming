package Arena;

import Droid.*;

import java.io.PrintStream;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class ArenaNvN extends Team{
    public int findNumsMembers(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість бійців в командах: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    public boolean checkTeam(BaseDroid[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].isAlive()){
                return true;
            }
        }
        return false;
    }
    public void printTeam(Team team){
        System.out.println("\nКоманда " + team.name + " : ");
        for (int i = 0; i < team.arr.length; i++){
            if(team.arr[i].isAlive()){
                System.out.println(team.arr[i]);
            }
            else{
                System.out.println(team.arr[i].getName()+" знищений!");
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
    public void printResultsRound(Team team1, Team team2, int n){
        System.out.println("\nРезультат раунду #" + (n+1));
        printTeam(team1);
        printTeam(team2);
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

        int count = findNumsMembers();
        Team team1 = new Team();
        Team team2 = new Team();
        team1.arr = new BaseDroid[count];
        team2.arr = new BaseDroid[count];

        team1.initTeam();
        team2.initTeam();

        PrintStream old = System.out;
        System.setOut(new PrintStream(fileName));

        System.out.println("\n\nКоманди бійців:");
        printTeam(team1);
        printTeam(team2);

        int n = 0;
        while(true){
            System.out.println("\nРаунд #" + (n+1) + "... В бій!");

            teamMove(team1.arr, team2.arr);
            if(!checkTeam(team2.arr)){
                System.out.println("Команда " + team1.name + " перемогла!");
                System.out.println("Команда " + team2.name + " знищена!\n");
                break;
            }

            teamMove(team2.arr, team1.arr);
            if(!checkTeam(team1.arr)){
                System.out.println("Команда " + team2.name + " перемогла!");
                System.out.println("Команда " + team1.name + " знищена!\n");
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

}

