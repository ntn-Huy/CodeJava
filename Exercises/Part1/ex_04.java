package Part1;

class Product{
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product (String id,String name,double price,int quantity){
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    //get
    public String getId(){return id;}
    public String getName(){return name;}
    public double getPrice(){return price;}
    public int getQuantity(){return quantity;}
    public double getValue(){return this.price*this.quantity;}
    public void less5(){if(quantity<5){System.out.println(name);}}
}
public class ex_04 {
    public static void main(String[] args){
        // Danh sach san pham
        Product book = new Product("012","Book",10,100);
        Product glasses = new Product("013","Glasses",20,20);
        Product tShirt = new Product("014","T-shirt",5,4);

        // Tinh tong gia tri kho hang
        double totalValue = book.getValue()+glasses.getValue()+tShirt.getValue();
        System.out.println("Tong gia tri kho hang: "+totalValue+" $ ");
        
        // tim san pham dat nhat
        Product max = book;
        if(book.getPrice()<glasses.getPrice()){max=glasses;if(glasses.getPrice()<tShirt.getPrice()){max=tShirt;}}
        else if(book.getPrice()<tShirt.getPrice()) {max=tShirt;}
        System.out.println("San pham co gia dat nhat : "+max.getName());
        // Loc in ra san pham co SL<5
        System.out.println("San pham co so luong <5: ");
        book.less5();
        glasses.less5();
        tShirt.less5();

    }
    
}
