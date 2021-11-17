/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TrungLT
 */
public class LinearSearch {

    /**
     * @param args the command line arguments
     */
    final Scanner sc = new Scanner(System.in);

    public int checkInput(String str) {
        int n = 0;
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

    public void createArray(int a[]) {
        Random rd = new Random();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(n);
        }
    }

    public int linerSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public void displayArray(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if(i < a.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        LinearSearch searcher = new LinearSearch();

        int n = searcher.checkInput("Enter number of array:");
        
        int[] a  = new int[n];
        searcher.createArray(a);

        int key = searcher.checkInput("Enter search value:");
        
        System.out.print("The Array: ");
        searcher.displayArray(a);

        int foundIndex = searcher.linerSearch(a, key);
        System.out.println("Found " + key + " at index: " + foundIndex);
    }
}
