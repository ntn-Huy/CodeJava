package Eg8_BankAccount;

public class Account {
    //thuoc tinh
    private String accountNum;
    private String name;
    private double balance;

    //Ham dung
    public Account(String accountNum,String name,double balance){
        this.accountNum = accountNum;
        this.name = name;
        this.balance = balance;
    }

    // Getter setter
    public String getAccountNum(){return accountNum;}
    public String getName(){return name;}
    public double getBalance(){return balance;}

    public void setBalance(double balance){
        if (balance>0){this.balance=balance;}
    }

    // Hien thi thong tin
    public void displayInfo(){
        System.out.println("Account: "+accountNum+"| Name: "+name+"| Balance: "+balance);
    }
    //Nap tien
     public void deposit(double amount){
        if (amount>0){balance+=amount;}
        else{System.out.println("So tien nap khong hop le");}
        displayInfo();
        System.out.println("So du moi sau khi nap: "+balance);
        System.out.println();
    }

    //rut tien
    public void withdraw(double amount){
        if (amount>0 && amount<=balance){balance-=amount;}
        else{System.out.println("So tien rut khong hop le");}
        displayInfo();
        System.out.println("So du moi sau khi rut: "+balance);
        System.out.println();
    }

}
