public class User {
    private String name;
    private int pin;
    private Account account;
    private Transaction transaction;
    public User(String name,int pin,double balance){
        this.name=name;
        this.pin=pin;
        this.account=new Account(balance);
        this.transaction=new Transaction();
    }
    public String getName(){
        return name;
    }
    public boolean login(int enteredPin){
        if(enteredPin==pin){
            return true;
        }else{
            System.out.println("Incorrect Pin");
            return false;
        }
    }
    public void changePin(int newPin){
        pin=newPin;
        System.out.println("Pin changed successfully");
    }
    public Account getAccount(){
        return account;
    }
    public Transaction getTransaction(){
        return transaction;

    }
    
}
