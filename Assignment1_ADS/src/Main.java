import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    // Task 1: Print Digits
    public static void printDigits(int n) {
        if (n == 0) {
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    // Task 2: Array Methods
    public static void fillArray(int[] arr, int index, Scanner sc) {
        if (index == arr.length) {
            return;
        }
        arr[index] = sc.nextInt();
        fillArray(arr, index + 1, sc);
    }

    public static double findSum(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }
        return findSum(arr, n - 1) + arr[n - 1];
    }

    // Task 3

    public static String checkNumber(int n, int d){
        if(n < 2)
            return "Composite";

        if(n == 2){
            return "Prime!";
        }
        if(n % d == 0){
            return "Composite!";
        }
        if(d *d > n)
            return "Prime!";

        return checkNumber(n, d + 1);
    }

    //Task 4

    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n*factorial(n - 1);
    }

    //Task 5
    public static int findFibonachi(int n){
        if (n <= 1){
            return n;
        }
        return findFibonachi(n - 1) + findFibonachi(n - 2);
    }

    //Task 6
    public static int power(int n, int d){
        if (d == 0){
            return 1;
        }
        return n * power(n, d - 1);
    }

    //Task 7
    public static int reverseArray(int[] arr, int index) {
        if (index < 0) {
            return 0;
        }
        System.out.println(arr[index] + " ");
        return reverseArray(arr, index - 1);
    }

    //Task 8
    public static String isAllDigits(String s){
        if(s.isEmpty()){
         return "Yes";
        }
        char first = s.charAt(0);
        if(Character.isDigit(first)){
            return isAllDigits(s.substring(1));
        }else{
            return "No";
        }
    }
    //Task 9
    public static int binominal(int b, int k){
        if(k == 0 || k == b){
            return 1;
        }
        return binominal(b - 1, k - 1) + binominal(b - 1, k);
    }
    //Task 10
    public static int findGCD(int a, int s1){
        if(s1== 0){
         return a;
        }
        return findGCD(s1, a % s1);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TASK 1
        System.out.print("Task 1 - Enter a number: ");
        int n1 = scanner.nextInt();
        if (n1 == 0) System.out.println(0);
        else printDigits(n1);

        // TASK 2
        System.out.print("\nTask 2 - Enter number of elements: ");
        int n2 = scanner.nextInt();
        int[] arr = new int[n2];
        fillArray(arr, 0, scanner);
        System.out.println(findSum(arr, n2) / n2);

        // TASK 3
        System.out.println("Input a number:");
        int n3 = scanner.nextInt();
        System.out.println(checkNumber( n3, 2));

       // TASK 4
        System.out.println("Task 4\n" + "Input a number for factorial:" );
        int n4 = scanner.nextInt();
        System.out.println(factorial(n4));

        //TASK 5
        System.out.println("Task 5 \n" + "Input a number for find it in Fibonachi set:");
        int n5 = scanner.nextInt();
        System.out.println("Fiblonachi number:" + findFibonachi(n5));

        //TASK 6
        System.out.println("Task 6 \n" + "Input number");
        int n6 = scanner.nextInt();
        System.out.println("Input a rank of number");
        int d1 = scanner.nextInt();
        System.out.println("Result:" + power(n6, d1));

        //TASK 7
        System.out.println("Task 7\n" + "Input a number:");
        int n7 = scanner.nextInt();
        int arr7[] = new int[n7];
        System.out.println("Input a numbers:");
        fillArray(arr7, 0, scanner);
        System.out.println("Reverse order:");
        reverseArray(arr7, n7 - 1);
        System.out.println();

        //TASK 8
        System.out.println("Task 8\n" + "Input a number:");
        String s = scanner.nextLine();
        System.out.println(isAllDigits(s));

        //TASK 9
        System.out.println("Task 9\n" + "input a first number:");
        int b = scanner.nextInt();
        System.out.println("input a second number:");
        int k = scanner.nextInt();
        System.out.println(binominal(b, k));

        //TASK 10
        System.out.println("Task 10 \n" + "Input a number");
        int a = scanner.nextInt();
        System.out.println("Input a second number");
        int s1 = scanner.nextInt();
        System.out.println("GCD is:" + findGCD(a, s1));


    }
}