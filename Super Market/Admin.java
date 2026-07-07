import java.util.*;

class Admin{

    String email;
    String password;

    Admin(String email,String password){

        this.email = email;
        this.password = password;

    }
}

class AdminOperations{

    ArrayList<Product> products;
    ArrayList<Customer> customers;
    Scanner sc = new Scanner(System.in);

    AdminOperations(ArrayList<Product> products,ArrayList<Customer> customers){

        this.products = products;
        this.customers = customers;

    }

    void adminMenu(){

        int ch;

        do{

            System.out.println("1 Add Product");
            System.out.println("2 View Products");
            System.out.println("3 Delete Product");
            System.out.println("4 Add Customer");
            System.out.println("5 Search Product");
            System.out.println("6 Exit");

            ch = sc.nextInt();

            if(ch == 1){

                System.out.print("Enter id: ");
                int id = sc.nextInt();

                System.out.print("Enter name: ");
                String name = sc.next();

                System.out.print("Enter price: ");
                double price = sc.nextDouble();

                System.out.print("Enter qty: ");
                int qty = sc.nextInt();

                products.add(new Product(id,name,price,qty));
                System.out.println("Product Added");

            }
            else if(ch == 2){

                for(Product p : products){

                    System.out.println(p.id+" "+p.name+" "+p.price+" "+p.qty);

                }

            }
            else if(ch == 3){

                System.out.print("Enter id: ");
                int id = sc.nextInt();

                for(int i=0;i<products.size();i++){

                    if(products.get(i).id == id){

                        products.remove(i);
                        System.out.println("Deleted");

                    }

                }

            }
            else if(ch == 4){

                System.out.print("Enter email: ");
                String e = sc.next();

                System.out.print("Enter password: ");
                String p = sc.next();

                customers.add(new Customer(e,p));
                System.out.println("Customer Added");

            }
            else if(ch == 5){

                System.out.print("Enter name: ");
                String name = sc.next();

                for(Product p : products){

                    if(p.name.equalsIgnoreCase(name)){

                        System.out.println(p.id+" "+p.name+" "+p.price+" "+p.qty);

                    }

                }

            }

        }while(ch != 6);

    }
}