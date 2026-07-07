public class Admin {
    
    public void depositToUser(User user,double amount){
        user.getAccount().deposit(amount);
        user.getTransaction().receipt(user.getName(),"Admin Deposit",amount,user.getAccount().getBalance());
        System.out.println("Admin deposited amount successfully");

    }
    public void viewBalance(User user){
        System.out.println("Account Name: "+user.getName());
        System.out.println("Balance: "+user.getAccount().getBalance());
    }
}
