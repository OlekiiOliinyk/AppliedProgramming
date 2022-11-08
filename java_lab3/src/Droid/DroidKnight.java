package Droid;

import java.util.Scanner;
import java.util.Random;
public class DroidKnight extends BaseDroid{
    private int suppression;
    private int readyCharge;
    private int charge;

    public DroidKnight(){}
    public void scanInfo(){
        super.scanInfo();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть потужність подавлення ворожої атаки в хп: ");
        this.setSuppression(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Введіть кількість ходів для заряду подавлення: ");
        this.setReadyCharge(scanner.nextInt());;
        scanner.nextLine();

        this.setCharge(0);
    }

    public void move(BaseDroid[] allyArr, BaseDroid[] enemyArr){

        Random random = new Random();
        int randomIndex;
        do{
            randomIndex = random.nextInt(enemyArr.length);
        } while(!enemyArr[randomIndex].isAlive());

        attack(enemyArr[randomIndex]);
        if(isCharged()){
            suppressionEnemy(enemyArr[randomIndex]);
            setCharge(0);
        }
        else{
            chargeSuppression();
        }
    }

    public void chargeSuppression(){this.charge += 1;}

    public boolean isCharged(){ return this.charge == readyCharge;}

    public void suppressionEnemy(BaseDroid obj){
        Random random = new Random();
        int newDamage = obj.getDamage() - random.nextInt(this.suppression);
        System.out.println( this.getName() +" зменшив атаку " + obj.getName() + " на " + newDamage + " одиниць");
        if (newDamage < 10){
            newDamage = 10;
        }
        obj.setDamage(newDamage);
    }

    public int getCharge() {return charge;}
    public int getSuppression() {return suppression;}
    public int getReadyCharge() {return readyCharge;}

    public void setSuppression(int suppression) {this.suppression = suppression;}
    public void setCharge(int charge) {this.charge = charge;}

    public void setReadyCharge(int readyCharge) {this.readyCharge = readyCharge;}

    public String toString() {
        return "------------------------\n"+"Лицар: " + this.getName() +
                "\nЗдоров'я: " + this.getHealth() + "\nХодів до подавлення атаки ворога: " + (this.getReadyCharge() - this.getCharge());
    }
}
