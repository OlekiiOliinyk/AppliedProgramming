package Arena;

import Droid.*;

import java.util.Scanner;

public class Team {

protected String name;
protected BaseDroid[] arr;

    public void initTeam(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть назву команди: ");
        this.name = scanner.nextLine();
        initFighters(this.arr);
    }

    public void initFighters(BaseDroid[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = createWarriors();
            arr[i].scanInfo();
        }
    }

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
}
