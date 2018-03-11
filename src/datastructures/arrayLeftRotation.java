package datastructures;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/array-left-rotation/problem
public class arrayLeftRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt() % n;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        for (int i = d; i < n; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        for (int i = 0; i < d; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

}