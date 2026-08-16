package Part1.Ex_03;

public class ex_03 {
    public static void main(String[] args){
        BankAccount guest1 = new BankAccount("0123","Nguyen van A",1200);
        BankAccount guest2 = new BankAccount("0124","Nguyen van B",1000);
        BankAccount guest3 = new BankAccount("0125","Nguyen van C",500);
        guest1.displayInfo();
        guest2.displayInfo();
        guest3.displayInfo();
        System.out.printf("================================================================\n");
        System.out.println("Thao tac: ");
        // thao tac
        guest1.deposit(500);
        guest2.withdraw(100);
        guest3.deposit(200);

        

    }
    
}
