// Написать программу вычисления n-ого треугольного числа
import java.util.Scanner;

public class TriangleNumb {
    static int triNum (int value) {
        int res = 0;        
        while (value > 0) {
            res = res + value;
            value--;
        }
        return res;
    }

    static int triNumRec (int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return (n + triNumRec(n - 1));
        }
    }
   
    public static void main(String[] args) {
        System.out.print("Enter your natural number: ");
        Scanner sc = new Scanner(System.in);
        int numb = sc.nextInt();
        sc.close();        
        System.out.print("Your triangle number: " + triNumRec(numb));
    }    
}