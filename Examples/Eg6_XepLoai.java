// Xep loai hoc sinh theo GPA
import java.util.Scanner;
public class Eg6_XepLoai {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ten sinh vien: ");
        String name = scanner.nextLine();
        double gpa;
        do {
        System.out.print("Nhap diem GPA: ");
        gpa= scanner.nextDouble();
        }while (gpa > 4 || gpa <0) ;
        // logic xep loai
        String rank;
        if (gpa>=3.6){
            rank = "Xuat sac";
        } else if (gpa>=3.2){
            rank = "Gioi";
        } else if (gpa >= 2.5){
            rank = "Kha";
        } else {rank = "Trung binh/Yeu";}
        System.out.printf("Sinh vien: %s - GPA: %.2f - Xep loai: %s\n",name,gpa,rank);
       
        scanner.close();
    }
    
}