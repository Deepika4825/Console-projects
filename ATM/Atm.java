import java.util.*;

public class Atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        int n;
        while (true) {
            try {
                System.out.println("Enter the number of users to create:");
                n = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
            }
        }
        for (int i = 0; i < n; i++) {

            System.out.println("Enter the details : " + (i + 1));
            System.out.println("Name:");
            String name = sc.nextLine();
            int pin;
            while (true) {
                try {
                    System.out.println("Enter 4 digit Pin:");
                    pin = sc.nextInt();
                    if (pin >= 1000 && pin <= 9999) {
                        break;
                    } else {
                        System.out.println("Pin should be exactly four digits");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Enter numbers only.");
                    sc.nextLine();
                }
            }
            double balance;
            while (true) {
                try {
                    System.out.println("Initial Balance:");
                    balance = sc.nextDouble();
                    sc.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid amount!");
                    sc.nextLine();
                }
            }
            User u = new User(name, pin, balance);
            users.add(u);
        }
        int enteredPin;
        while (true) {
            try {
                System.out.println("Enter the pin to login:");
                enteredPin = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid PIN input!");
                sc.nextLine();
            }
        }
        User currentuser = null;
        for (User u : users) {
            if (u.login(enteredPin)) {
                currentuser = u;
                break;
            }
        }
        if (currentuser == null) {
            System.out.println("Invalid Pin");
            return;
        }
        int choice;
        
        do {
            System.out.println("ATM System");
            System.out.println("1.Check Balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Transfer");
            System.out.println("5.Mini Statement");
            System.out.println("6.Change Pin");
            System.out.println("7.Exit");
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            
            

            
            switch (choice) {

                case 1:
                    System.out.println("Balance:" + currentuser.getAccount().getBalance());
                    break;
                case 2:
                    try {
                        System.out.println("Enter Deposit Amount:");
                        double depos = sc.nextDouble();

                        currentuser.getAccount().deposit(depos);

                        currentuser.getTransaction().receipt(
                                currentuser.getName(),
                                "Deposit",
                                depos,
                                currentuser.getAccount().getBalance());
                    } catch (Exception e) {
                        System.out.println("Invalid amount");
                        sc.nextLine();
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter withdrawal amount:");
                        double wd = sc.nextDouble();

                        currentuser.getAccount().withdraw(wd);

                        currentuser.getTransaction().receipt(
                                currentuser.getName(),
                                "Withdraw",
                                wd,
                                currentuser.getAccount().getBalance());
                    } catch (Exception e) {
                        System.out.println("Invalid amount!");
                        sc.nextLine();
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter the receiver name:");
                    String receivername = sc.nextLine();
                    User receiver = null;
                    for (User u : users) {
                        if (u.getName().equalsIgnoreCase(receivername)) {
                            receiver = u;
                            break;
                        }
                    }
                    if (receiver == null) {
                        System.out.println("Receiver not found");
                        break;
                    }
                    try {
                        System.out.println("Enter transfer amount:");
                        double amounts = sc.nextDouble();
                        currentuser.getAccount().Transfer(receiver.getAccount(), amounts);
                        currentuser.getTransaction().receipt(
                                currentuser.getName(),
                                "Transfer",
                                amounts,
                                currentuser.getAccount().getBalance());
                    } catch (Exception e) {
                        System.out.println("Invalid amount");
                        sc.nextLine();
                    }
                    break;
                case 5:
                    currentuser.getTransaction().ministatement();
                    break;
                case 6:
                    int newPin;
                    while (true) {
                        try {
                            System.out.println("Enter new pin:");
                            newPin = sc.nextInt();
                            if (newPin >= 1000 && newPin <= 9999) {
                                break;
                            } else {
                                System.out.println("Pin should be exactly four digits");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                            sc.nextLine();
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

        } while (choice != 8);
    }
}