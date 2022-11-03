// Реализовать алгоритм пирамидальной сортировки (HeapSort) 

import java.util.Random;
import java.util.Scanner;

public class HeapSort {

    static void randArr(int[] array) {
        Random random = new Random();
                 
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-50, 50);
        }
    } 
        
    
    static void printArr(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }    
    
    static void creatHeap(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            creatHeap(arr, n, largest);
        }
    }

    static void sortHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            creatHeap(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            creatHeap(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter your array size: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();

        int[] arr = new int[size];
        randArr(arr);
        System.out.println("Your array: ");
        printArr(arr);

        sortHeap(arr);
        System.out.println("Your sorted array: ");
        printArr(arr);
    }
}
