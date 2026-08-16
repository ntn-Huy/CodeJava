package Part1.Ex_03;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    //constructors
    public BankAccount (String accountNumber, String ownerName,double balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    //Methods
    public void displayInfo(){
        System.out.println("Num: "+accountNumber+" | Name: "+ownerName+" | Balance: "+balance);
    }
    public void deposit(double amount){
        if (amount>0){balance+=amount;}
        else {System.out.println("So tien nap ko hop le!");}
        displayInfo();
        System.out.println("So tien sau khi nap la: "+balance);
    }
    public void withdraw(double amount){
        if (amount<balance && amount >0){balance-=amount;}
        else {System.out.println("So tien rut ko hop le!");}
        displayInfo();
        System.out.println("So tien sau khi rut la: "+balance);
    }
    // get set
    public String getAccountNumber(){return accountNumber;}
    public String getOwnerName(){return ownerName;}
    public double getBalance(){return balance;}
    public void setBalance(double balance){
        if (balance >0){this.balance=balance;}
    }

    
}
