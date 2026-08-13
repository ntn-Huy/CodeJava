package Part1;
/*Viết chương trình EmployeeManagement thực hiện:
    Input: Nhập từ bàn phím: Mã số nhân viên | Họ tên | Tuối | Hệ số lương 
    Output: Bảng thông tin nhân viên
*/ 
import java.util.Scanner;
public class ex_01 {
    public static void main(String[] args){
        // Input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap msnv: ");
        String ms = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Nhap Ho va Ten: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Nhap tuoi: ");
        int age = scanner.nextInt();
        System.out.println("Nhap He so luong: ");
        double sal = scanner.nextDouble();
        scanner.nextLine();   
        scanner.close();
        // Output
        System.out.printf("MS: %s | Name: %s | Age: %d | Salary: %.2f",ms,name,age,sal);
    }
    
}
