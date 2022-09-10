import java.util.Scanner;

public class Main {
    public static int findNum(Fibonacci[] arr, int amount,int lastDigit){ // метод пошуку чисел з ідентичною останньою цифрою
        int k = 0;
        System.out.print("Числа Фібоначчі з останньою цифрою " + lastDigit + ": ");
        for(int i = 0; i < amount; i++){
            if ((arr[i].getFibNum() - lastDigit) % 10 == 0){ // формула схожості
                System.out.print( arr[i].getFibNum() + " ");
                k++;
            }
        }
        return k;
    }
    public static void createArr(Fibonacci[] arr, int amount){
        int next, i = 0, j = 1;
        for(int k = 0; k < amount; k++) { // цикл заповнення числами фібоначі
            next = i + j;
            arr[k] = new Fibonacci();
            arr[k].setFibNum(i);
            arr[k].setOrderOfNum(k + 1);
            i = j;
            j = next;
        }
    }
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Введіть кількість чисел Фібоначчі: ");
        int amount = scan.nextInt();
        if (amount <= 0){ return; }

        System.out.print("Введіть останню цифру для пошуку чисел: ");
        int lastDigit = scan.nextInt();

        Fibonacci[] arr = new Fibonacci[amount];      //Ініціалізація масиву екземплярів класу
        createArr(arr, amount);
        System.out.print("\nКількість чисел з останньою цифрою " + lastDigit + ": " +  findNum(arr, amount, lastDigit));
    }
}
