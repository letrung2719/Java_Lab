/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TrungLT
 */
public class BinarySearch {

    final Scanner sc = new Scanner(System.in);

    public int checkInput(String str) {
        int n;
        while (true) {
            try {
                System.out.println(str);
                n = sc.nextInt();
                if (n <= 0) {
                    continue;
                }
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        return n;
    }

    public void createArray(int[] a) {
        Random rd = new Random();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(n);
        }
    }

    public void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public void bubbleSort(int[] a) {
        int n = a.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    int binarySearch(int[] a, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (a[middle] == value) {
            return middle;
        } else if (a[middle] > value) {
            return binarySearch(a, value, left, middle - 1);
        } else {
            return binarySearch(a, value, middle + 1, right);
        }
    }

    public static void main(String[] args) {
        BinarySearch searcher = new BinarySearch();

        int n = searcher.checkInput("Enter number of array:");

        int[] a = new int[n];

        searcher.createArray(a);

        int key = searcher.checkInput("Enter search value:");

        searcher.bubbleSort(a);

        System.out.print("Sorted array: ");
        searcher.displayArray(a);

        int foundIndex = searcher.binarySearch(a, key, 0, a.length - 1);
        System.out.println("\nFound " + key + " at index: " + foundIndex);
    }
}
