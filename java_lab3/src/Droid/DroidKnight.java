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

        System.out.print("������ ��������� ���������� ������ ����� � ��: ");
        this.setSuppression(scanner.nextInt());
        scanner.nextLine();

        System.out.print("������ ������� ���� ��� ������ ����������: ");
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
        System.out.println( this.getName() +" ������� ����� " + obj.getName() + " �� " + newDamage + " �������");
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
        return "------------------------\n"+"�����: " + this.getName() +
                "\n������'�: " + this.getHealth() + "\n���� �� ���������� ����� ������: " + (this.getReadyCharge() - this.getCharge());
    }
}
