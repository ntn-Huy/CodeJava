package Part1.ex_02;
/*
    Viết lớp TextProcessor chứa phương thức public static String formatName(String rawName) thực hiện:
    Input: chuoi hoten bi loi dinh dang VD: "nguEn tHanh nHAt HUy"
    Ouput: xoa khong trang thua dau cuoi | chuyen doi hoten ve dang chuan "Nguyen Thanh Nhat Huy"
*/
import java.util.Scanner;
public class ex_02{
    public static void main(String[] args){
        //input
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nhap ten loi : ");
        String name = scanner.nextLine();
        scanner.close();
        String result = TextProcessor.formatName(name);
        System.out.println("Ban dau: [" + name + "]");
        System.out.println("Chuan hoa: [" + result + "]");


    }
    
}
