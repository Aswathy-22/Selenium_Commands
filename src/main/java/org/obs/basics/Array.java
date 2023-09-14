package org.obs.basics;
import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
        int arr[] = new int[5];
//Initialize an Array
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        Scanner sc = new Scanner(System.in);
//Reading from Keyboard
        int brr[] = new int[5];
        brr[0] = sc.nextInt();
        brr[1] = sc.nextInt();
        brr[2] = sc.nextInt();
        brr[3] = sc.nextInt();
        brr[4] = sc.nextInt();
        for (int i = 0; i < brr.length; i++) {
            System.out.println(brr[i]);
        }
//we can declare,instantiate,initialise the java array together
        int crr[] = {10, 20, 30, 40, 50};
        for (int i = 0; i < crr.length; i++) {
            System.out.println(crr[i]);
        }
//For loop
        int drr[] = new int[5];
        for (int i = 0; i < drr.length; i++) {
            drr[i] = sc.nextInt();
        }
        for (int i = 0; i < drr.length; i++) {
            System.out.println(drr[i]);
        }
//For each loop
        int arrname[] = {1, 3, 5, 7, 9};
        for (int s : arrname) {
            System.out.println(s);
        }

    }
}
