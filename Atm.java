import java.util.*;
public class Atm{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<User> users=new ArrayList<>();
        System.out.println("Enter the number of users to create:");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Enter the details : "+(i+1));
            System.out.println("Name:");
            String name=sc.nextLine();
            System.out.println("Pin:");
            int pin;
            while(true){
                pin=sc.nextInt();
                if(pin>=1000 && pin<=9999){
                    break;
                }else{
                    System.out.println("Pin should exactly four digits");
                }
            }
            System.out.println("Initial Balance:");
            double balance=sc.nextDouble();
            sc.nextLine();
            User u=new User(name,pin,balance);
            users.add(u);
        }
        System.out.println("Enter the pin to login:");
        int enteredPin=sc.nextInt();
        User currentuser=null;
        for(User u:users){
            if(u.login(enteredPin)){
                currentuser=u;
                break;
            }
                

        }
        if(currentuser==null){
            System.out.println("Invalid Pin");
            return;
        }
        int choice;
        do{
            System.out.println("ATM System");
            System.out.println("1.Check Balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Tranfer");
            System.out.println("5.Mini Statement");
            System.out.println("6.Change Pin");
            System.out.println("Enter choice:");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Balance:"+currentuser.getAccount().getBalance());
                    break;
                case 2:
                    System.out.println("Enter Deposit Amount:");
                    double depos=sc.nextDouble();
                    currentuser.getAccount().deposit(depos);
                    currentuser.getTransaction().receipt(currentuser.getName(),"Deposit",depos,currentuser.getAccount().getBalance());
                    break;
                case 3:
                    System.out.println("Enter withdrawal amount:");
                    double wd=sc.nextDouble();
                    currentuser.getAccount().withdraw(wd);
                    currentuser.getTransaction().receipt(currentuser.getName()," withdraw ",wd,currentuser.getAccount().getBalance());
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter the receiver name:");
                    String receivername=sc.nextLine();
                    User receiver=null;
                    for(User u:users){
                        if(u.getName().equalsIgnoreCase(receivername)){
                            receiver=u;
                            break;
                        }

                    }
                    if(receiver==null){
                        System.out.println("Receiver not found");
                        break;
                    }
                    System.out.println("Enter transfer amount:");
                    double amounts=sc.nextDouble();
                    currentuser.getAccount().Transfer(receiver.getAccount(),amounts);
                    currentuser.getTransaction().receipt(currentuser.getName(),"Transfer",amounts,currentuser.getAccount().getBalance());
                    break;
                case 5:
                    currentuser.getTransaction().ministatement();
                    break;
                case 6:
                    System.out.println("Enter new pin:");
                    int newPin;
                    while (true) { 
                        newPin=sc.nextInt();
                        if(newPin>=1000 && newPin<=9999){
                            break;
                        }else{
                            System.out.println("Pin should be exactly four digits");
                        }
                        
                    }
                    currentuser.changePin(newPin);
                    break;
                case 7:
                    System.out.println("Thank you using the ATM");
                    break;
                
                default:
                    System.out.println("Invalid Choice");


            }



        }
        while(choice!=7);
        
        

    }
}