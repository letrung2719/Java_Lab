/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibbonacci;

/**
 *
 * @author TrungLT
 */
public class Fibbonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("The 45 sequence Fibonacci: ");
        fibo(10,0,1);
    }
    
    public static int fibo(int num, int a, int b){
        if(num < 1){
            return a;
        }
        
        System.out.print(a + " ");
        return fibo(num-1, b, a+b);  
    }
    
}
