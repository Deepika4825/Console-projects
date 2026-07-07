public class Account {
    private double balance;
    public Account(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance=balance+amount;
        System.out.println("Amount deposited: "+amount);
        System.out.println("Current Balance:"+balance);
    }
    public void withdraw(double amount){
        if(amount>balance){
            System.out.println("Insufficient Amount");
        }else if(amount%100!=0){
            System.out.println("Only 100,200,500 are allowed");
        }else{
            balance=balance-amount;
            System.out.println("Wihtdraw successful");
            System.out.println("Current Balance:"+balance);
        }
    }
    public void Transfer(Account receiver,double amount){
        if(amount>balance){
            System.out.println("Insufficient Amount for transfer");
        }else{
            balance=balance-amount;
            receiver.deposit(amount);
            System.out.println("Transfer successful");
            System.out.println("Current Balance:"+balance);
        }

    }
    
}
