package Droid;

import java.util.Random;
import java.util.Scanner;

public abstract class BaseDroid {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int damage;

    public BaseDroid(){}

    public void scanInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------------");
        System.out.print("¬вед≥ть ≥м'€ б≥йц€: ");
        this.setName(scanner.nextLine());

        System.out.print("¬вед≥ть здоров'€ б≥йц€: ");
        this.setHealth(scanner.nextInt());
        this.setMaxHealth(getHealth());
        scanner.nextLine();

        System.out.print("¬вед≥ть атаку б≥йц€: ");
        this.setDamage(scanner.nextInt());
        scanner.nextLine();
    }

    public abstract void move(BaseDroid[] allyArr, BaseDroid[] enemyArr);

    public void attack(BaseDroid obj){
        Random random = new Random();
        int avgDamage = getDamage();
        int realDamage = random.nextInt((avgDamage + 10) - (avgDamage - 10)) + avgDamage - 10;
        if (realDamage < 1){ realDamage = 1; }
        System.out.println(getName() + " наносить удар "+obj.getName()+" : -" + realDamage + " hp");
        int newObjHealth = obj.getHealth() - realDamage;
        obj.setHealth(newObjHealth);
        if (obj.getHealth() < 0){
            obj.setHealth(0);
        }
    }
    public boolean isAlive(){
        return this.health > 0;
    }

    public void setName(String name) {this.name = name;}
    public void setDamage(int damage) {this.damage = damage;}
    public void setHealth(int health) {this.health = health;}
    public void setMaxHealth(int maxHealth) {this.maxHealth = maxHealth;}

    public int getMaxHealth() {return maxHealth;}
    public int getDamage() {return damage;}
    public String getName() {return name;}
    public int getHealth() {return health;}
}
