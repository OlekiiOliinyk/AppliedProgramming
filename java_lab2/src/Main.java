import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class Main {

    public static void createArr(Abiturient[] arr){
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i <  arr.length; i++){
            arr[i] = new Abiturient();

            System.out.print("\nВведіть ID: ");
            arr[i].setId(scan.nextInt());
            scan.nextLine();

            System.out.print("Введіть прізвище: ");
            arr[i].setSurname(scan.nextLine());

            System.out.print("Введіть ім'я: ");
            arr[i].setName(scan.nextLine());

            System.out.print("Введіть по-батькові: ");
            arr[i].setPatronymic(scan.nextLine());

            System.out.print("Введіть адресу: ");
            arr[i].setAddress(scan.nextLine());

            System.out.print("Введіть телефон: ");
            arr[i].setTelephone(scan.nextLine());

            System.out.print("Введіть середній бал: ");
            arr[i].setAvgScore(scan.nextDouble());
            scan.nextLine();
        }
    }

    public static void compareName(Abiturient[] arr, String name){
        System.out.print("Абітурієнти з іменем " + name + ": ");

        int k = 0;

        for(int i = 0; i < arr.length; i++){

            if (name.equalsIgnoreCase(arr[i].getName())){
                System.out.print(arr[i]);
                k++;
            }
        }
        if (k == 0) {
            System.out.print("Немає");
        }
    }

    public static void compareScore(Abiturient[] arr, double score){

        System.out.print("Абітурієнти з більшим балом за " + score + ": ");
        int k = 0;
        for(int i = 0; i <  arr.length; i++){

            if (arr[i].getAvgScore() > score){
                System.out.print(arr[i]);
                k++;
            }
        }
        if (k == 0) {
            System.out.print("Немає");
        }
    }

    public static void bestAbiturient(Abiturient[] arr, int n){

        n = n > arr.length ? arr.length : n;

        Arrays.sort(arr, new Comparator<Abiturient>() {
            @Override
            public int compare(Abiturient o1, Abiturient o2) {
                return (int)(o1.getAvgScore() - o2.getAvgScore());
            }
        });
        for(int i = 0; i < n; i++){
            System.out.print(arr[arr.length-i-1]);
        }
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("Введіть кількість абітурієнтів: ");
        int count = scan.nextInt();
        scan.nextLine();

        Abiturient[] arr = new Abiturient[count];
        createArr(arr);

        System.out.print("\nВведіть ім'я абітурієнта для пошуку: ");
        String name = scan.nextLine();
        compareName(arr, name);

        System.out.print("\n\nВведіть бал абітурієнта для пошуку більших: ");
        double score = scan.nextDouble();
        compareScore(arr, score);

        System.out.print("\n\nВведіть кількість найкращих студентів за середнім балом: ");
        int n = scan.nextInt();
        bestAbiturient(arr, n);
    }
}
