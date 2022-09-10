package Droid;

import java.util.Scanner;
import java.util.Random;
public class DroidAssasin extends BaseDroid{
    private double chanceCrit;
    private int charge;
    private int readyCharge;
    public DroidAssasin(){}

    public void scanInfo(){
        super.scanInfo();
        Scanner scanner = new Scanner(System.in);

        System.out.print("������ ���� ����. �����(�� ����� 1): ");
        this.setChanceCrit(scanner.nextFloat() % 1);
        scanner.nextLine();

        System.out.print("������ ������� ���� ��� ����. �����: ");
        this.setReadyCharge(scanner.nextInt());
        scanner.nextLine();

        this.setCharge(0);
    }

    public void chargeCrit(){this.charge += 1;}
    public boolean isChargedCrit(){return this.charge == this.readyCharge;}

    public void setCharge(int charge) {this.charge = charge;}
    public void setChanceCrit(float chanceCrit) {this.chanceCrit = chanceCrit;}

    public void setReadyCharge(int readyCharge) {this.readyCharge = readyCharge;}

    public void move(BaseDroid[] allyArr, BaseDroid[] enemyArr){
        Random random = new Random();
        int randomIndex;
        do{
            randomIndex = random.nextInt(enemyArr.length);
        } while(!enemyArr[randomIndex].isAlive());

        if(isChargedCrit()){
            criticalAttack(enemyArr[randomIndex]);
            setCharge(0);
        }
        else{
            attack(enemyArr[randomIndex]);
            chargeCrit();
        }
    }

    public void criticalAttack(BaseDroid obj){
        Random random = new Random();
        double chance = random.nextDouble();
        if (this.getChanceCrit() >= chance){
            System.out.println("��������� ���� �� ���� " + obj.getName() + " �������!!!");
            kill(obj);
        }
        else{
            System.out.println("��������� ���� �� ���� " + obj.getName() + " �� �������");
        }
    }
    public void kill(BaseDroid obj){
        obj.setHealth(0);
    }
    public int getCharge() {return charge;}
    public double getChanceCrit() {return chanceCrit;}
    public int getReadyCharge() {return readyCharge;}

    public String toString() {return "------------------------\n"+"������: " + this.getName() +
            " \n������'�: " + this.getHealth() + " \n���� �� ����. �����: "
            + (this.getReadyCharge() - this.getCharge());}
}
