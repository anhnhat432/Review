/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonancci;

/**
 *
 * @author FPT
 */
public class fibonancci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = 45;
        System.out.println("Dãy Fibonacci " + n + " số đầu tiên: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + ", ");
        }
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
// Chương trình này tính và in ra dãy Fibonacci gồm n số đầu tiên bằng cách sử dụng đệ quy.
//Dãy Fibonacci là một chuỗi các số bắt đầu với hai số 0 và 1, sau đó các số tiếp theo được tính bằng tổng của hai số trước đó trong chuỗi.
// 
    
    

