package Droid;

import java.util.Random;
import java.util.Scanner;

public class DroidTank extends BaseDroid{
    private int charge;

    private int readyCharge;
    public DroidTank(){}
    public void scanInfo(){
        super.scanInfo();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість ходів для заряду гармати: ");
        this.setReadyCharge(scanner.nextInt());
        scanner.nextLine();

        this.setCharge(0);
    }
    public void move(BaseDroid[] allyArr, BaseDroid[] enemyArr){

        if (isCharged()){
            for(int i = 0; i < enemyArr.length; i++){
                if(enemyArr[i].isAlive()) {
                    bombarding(enemyArr[i]);
                }
            }
            setCharge(0);
        }
        else{
            chargeTank();
        }
    }
    public void bombarding(BaseDroid obj){
        Random random = new Random();
        int avgDamage = getDamage();
        int realDamage = random.nextInt((avgDamage + 10) - (avgDamage - 10)) + avgDamage - 10;
        System.out.println(getName() + " наносить ракетний удар "+obj.getName()+" : -" + realDamage + " hp");
        int newObjHealth = obj.getHealth() - realDamage;
        obj.setHealth(newObjHealth);
        if (obj.getHealth() < 0){
            obj.setHealth(0);
        }
    }

    public boolean isCharged(){return this.charge == this.readyCharge;}
    public void chargeTank(){this.charge += 1;}

    public void setReadyCharge(int readyCharge) {this.readyCharge = readyCharge;}
    public void setCharge(int charge) {this.charge = charge;}
    public int getCharge() {return charge;}
    public int getReadyCharge() {return readyCharge;}

    public String toString() {
        return "------------------------\n"+"Танк: " + this.getName() + "\nЗдоров'я: "
                + this.getHealth() + " \nХодів до вистрілу: " + (this.getReadyCharge() - this.getCharge());
    }
}
