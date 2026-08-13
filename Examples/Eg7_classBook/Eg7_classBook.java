package Eg7_classBook;
// class book bao gom title author price

public class Eg7_classBook {
    // cac thuoc tinh
    private String title;
    private String author;
    private double price;

    // Ham dung (constructor) Dung de khoi tao doi tuong
    public Eg7_classBook(String title,String author,double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    //getters vaf setter
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public double getPrice(){return price;}

    public void setPrice(double price){
        if (price >0){ this.price=price;}
    }

    public void displayInfo(){
        System.out.println("Sach: "+title+"| Tac gia: "+author+"| Gia: "+price);
    }
}