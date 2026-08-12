package Eg8_BankAccount;

public class Main {
    public static void main(String[] args){
        Account acc1 = new Account("00123","Nguyen Van Minh",500.5);
        Account acc2 = new Account("00124","Nguyen Van B",50.5);
        Account acc3 = new Account("00125","Nguyen Van c",1500.5);

        acc1.displayInfo();
        acc2.displayInfo();
        acc3.displayInfo(); 
        acc1.deposit(100);
        acc2.deposit(10000);
        acc3.deposit(1000);
        acc1.withdraw(100);
        acc2.withdraw(1000);
        acc3.withdraw(10);
        acc1.displayInfo();
        acc2.displayInfo();
        acc3.displayInfo();
    }
}
