import java.util.*;

class Store{

    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void start(){

        admins.add(new Admin("admin@gmail.com","admin"));
        customers.add(new Customer("user@gmail.com","123"));

        products.add(new Product(1,"Rice",50,20));
        products.add(new Product(2,"Oil",120,10));

        System.out.println("Welcome");

        System.out.print("Enter email: ");
        String email = sc.next();

        System.out.print("Enter password: ");
        String pass = sc.next();

        for(Admin a : admins){

            if(a.email.equals(email) && a.password.equals(pass)){

                AdminOperations ao = new AdminOperations(products,customers);
                ao.adminMenu();
                return;

            }

        }

        for(Customer c : customers){

            if(c.email.equals(email) && c.password.equals(pass)){

                CustomerOperations co = new CustomerOperations(products);
                co.customerMenu(c);
                return;

            }

        }

        System.out.println("Invalid Login");

    }
}