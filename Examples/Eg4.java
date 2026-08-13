/*
    Nhap vao 1 so nguyen n va in ra so dao nguoc cua no
*/

import java.util.Scanner;
public class Eg4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao 1 so nguyen n: ");
        int n = scanner.nextInt();
        int reverse = 0;
        while(n != 0){
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n /= 10;
        }
        System.out.println("So dao nguoc cua no la: " + reverse);
        scanner.close();
    }  
}
