public class Eg2_KieuDuLieu {
    public static void main (String[] args) {
        // 1.Cac kieu du lieu
        int age = 20;
        double gpa = 3.5;
        boolean isActive = true;
        char grade = 'A';
        // 2. Hang so
        final double PI = 3.14;
        
        // chia
        int a=10;
        int b=3;
        System.out.println("a/b="+(a/b));
        System.out.println("a/b="+(a/(double)b));

        // 4. Ep kieu
        double price =9.99;
        int roundePrice = (int) price;
        
        System.out.println("Tuoi: "+ age + ", GPA " + gpa + ", Grade " +grade);
        System.out.println("Gia: "+ roundePrice);
        System.out.println("Bool: "+ isActive);
        System.out.println("Pi= "+ PI);
        
    }
}
