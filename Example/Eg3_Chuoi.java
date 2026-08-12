public class Eg3_Chuoi {
    public static void main (String[] args) {
        String name1 = "Java";
        String name2 = new String("Java");
        // so sanh dia chi o nho sai
        System.out.println("Dung == : " + (name1 == name2)); // false
       // so sanh dung
        System.out.println("Dung equal: "+ name1.equals(name2)); // true
        
        // cac cach dung cua string
        String text = "  Lap trinh Java  ";
        System.out.println("Text goc: "+text);
        System.out.println("Do dai: "+text.length());
        System.out.println("IN HOA: "+text.toUpperCase());
        System.out.println("Xoa khoang trang: "+text.trim());

        // Noi chuoi StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("xin chao: ").append("Lap trinh vien ").append("Java");
        System.out.println(sb.toString());
    }
    
}
