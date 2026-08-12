package Eg7_classBook;
public class Eg7_MainApp {
    public static void main(String[] args){
        Eg7_classBook book1 = new Eg7_classBook("clean code","Robert",50);
        Eg7_classBook book2 = new Eg7_classBook("Java","Conan",40);

        book1.displayInfo();
        book2.displayInfo();
        
        book1.setPrice(35);
        System.out.println("Gia moi cua sach "+book1.getTitle()+" la: "+book1.getPrice());
    }
}
