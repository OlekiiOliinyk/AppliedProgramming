package Droid;

import java.util.Scanner;
import java.util.Random;
public class DroidHealer extends BaseDroid{
    private int heal;
    private int charge;
    private int readyCharge;
    public DroidHealer(){}
    public void scanInfo(){
        super.scanInfo();
        Scanner scanner = new Scanner(System.in);

        System.out.print("¬вед≥ть здатн≥сть ремонту: ");
        this.setHeal(scanner.nextInt());
        scanner.nextLine();

        System.out.print("¬вед≥ть к≥льк≥сть ход≥в дл€ зар€ду ремонту: ");
        this.setReadyCharge(scanner.nextInt());
        scanner.nextLine();

        this.setCharge(0);
    }
    public int findBestHeal(BaseDroid[] arr){
        int bestIndex = 0;
        int minHealth = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(minHealth > arr[i].getHealth() && arr[i].isAlive()){
                bestIndex = i;
                minHealth = arr[i].getHealth();
            }
        }
        return bestIndex;
    }

    public void move(BaseDroid[] allyArr, BaseDroid[] enemyArr){
        Random random = new Random();
        int randomIndex;

        do{
            randomIndex = random.nextInt(enemyArr.length);
        } while(!enemyArr[randomIndex].isAlive());
        attack(enemyArr[randomIndex]);

        int indexHeal = findBestHeal(allyArr);
        if(isCharged()){
            healAlly(allyArr[indexHeal]);
            setCharge(0);
        }
        else{
            chargeHeal();
        }
    }
    public void healAlly(BaseDroid obj){
        System.out.println(this.getName() + " в≥дремонтував " + obj.getName() + " на " + heal + " хп");
        if (obj.getHealth() + heal > obj.getMaxHealth()){
            obj.setHealth(obj.getMaxHealth());
        }
        else{
            obj.setHealth(obj.getHealth() + heal);
        }

    }
    public boolean isCharged(){
        return this.charge == this.readyCharge;
    }
    public void chargeHeal(){
        this.charge += 1;
    }
    public int getHeal() {return heal;}
    public int getCharge() {return charge;}
    public int getReadyCharge() {return readyCharge;}

    public void setHeal(int heal) {this.heal = heal;}
    public void setCharge(int charge) {this.charge = charge;}
    public void setReadyCharge(int readyCharge) {this.readyCharge = readyCharge;}

    public String toString() {
        return "------------------------\n"+"ћедик: " + this.getName() + " \n«доров'€: " + this.getHealth()
                + "\n’од≥в до ремонту: " + ( this.getReadyCharge() - this.getCharge());
    }
}
