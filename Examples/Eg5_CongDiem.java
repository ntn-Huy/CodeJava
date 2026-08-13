
/* Bai toan tinh diem vote
    * Diem thuong ky: Neu 10 vote vao cac cot thuong ky (co 3 cot)
    * Neu 20 vote cong 2 diem vao tung cot cua diem thuong ky
    * Neu 50 vote cong 1 diem vao tung cot cua diem Gk && 3 cot thuong ky moi cot 2 diem
    * Neu 100 vote cong 2 diem vao cot cua diem GK && 3 cot thuong ky moi cot 3 diem
    * Output:
    * Nhap sinh vien
    *  Nhap vote
    * Tu dong in ra cot diem thuong ky va diem giua ky
*/

import java.util.Scanner;
public class Eg5_CongDiem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Nhap so ten
        System.out.print("Nhap ten sv: ");
        String name = scanner.nextLine();

        // Nhap diem
        System.out.print("Nhap diem tk 1: ");
        double tk1 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhap diem tk 2: ");
        double tk2 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhap diem tk 3: ");
        double tk3 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhap diem gk: ");
        double gk = scanner.nextDouble();
        scanner.nextLine();
        
        // Nhap so vote
        System.out.println("Nhap so vote: ");
        int vote = scanner.nextInt();

        //logic cong diem
        int diemCongTk = 0;
        int diemCongGk =0 ;
        if (vote >=100){
            diemCongTk =3;
            diemCongGk =2;
        } else if (vote >= 50){
            diemCongTk =2;
            diemCongGk=2;
        } else if (vote >=20){
            diemCongTk =2;
        } else if (vote >= 10){
            diemCongTk=1;
        }

        // Cong diem
        tk1 += diemCongTk;
        tk2 += diemCongTk;
        tk3 += diemCongTk;
        gk += diemCongGk;
        if (tk1>10){tk1=10;}
        if (tk2>10){tk2=10;}
        if (tk3>10){tk3=10;}
        if (gk>10){gk=10;}

        // Hien thi
        System.out.println("Sinh vien: "+name);
        System.out.println("Diem tk 1: "+tk1);
        System.out.println("Diem tk 2: "+tk2);
        System.out.println("Diem tk 3: "+tk3);
        System.out.println("Diem gk : "+gk);


        scanner.close();
    } 
}
