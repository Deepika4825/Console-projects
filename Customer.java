import java.util.*;

class Customer{

    String email;
    String password;
    double credit;
    int points;

    Customer(String email,String password){

        this.email = email;
        this.password = password;
        this.credit = 1000;
        this.points = 0;

    }
}

class CustomerOperations{

    ArrayList<Product> products;
    Scanner sc = new Scanner(System.in);

    CustomerOperations(ArrayList<Product> products){

        this.products = products;

    }

    void customerMenu(Customer c){

        ArrayList<CartItem> cart = new ArrayList<>();
        int ch;

        do{

            System.out.println("1 View Products");
            System.out.println("2 Add to Cart");
            System.out.println("3 Remove from Cart");
            System.out.println("4 Checkout");
            System.out.println("5 Exit");

            ch = sc.nextInt();

            if(ch == 1){

                for(Product p : products){

                    System.out.println(p.id+" "+p.name+" "+p.price+" "+p.qty);

                }

            }
            else if(ch == 2){

                System.out.print("Enter id: ");
                int id = sc.nextInt();

                System.out.print("Enter qty: ");
                int q = sc.nextInt();

                for(Product p : products){

                    if(p.id == id && p.qty >= q){

                        cart.add(new CartItem(p.id,p.name,p.price,q));
                        System.out.println("Added to cart");

                    }

                }

            }
            else if(ch == 3){

                System.out.print("Enter id: ");
                int id = sc.nextInt();

                for(int i=0;i<cart.size();i++){

                    if(cart.get(i).id == id){

                        cart.remove(i);
                        System.out.println("Removed");

                    }

                }

            }
            else if(ch == 4){

                double total = 0;

                for(CartItem i : cart){

                    total += i.price * i.qty;

                }

                System.out.println("Total = "+total);

                if(total > c.credit){

                    System.out.println("Not enough credit");

                }
                else{

                    c.credit -= total;

                    if(total >= 5000){

                        c.credit += 100;
                        System.out.println("Cashback 100 added");

                    }
                    else{

                        c.points += total/100;

                    }

                    if(c.points >= 50){

                        c.credit += 100;
                        c.points = 0;
                        System.out.println("Reward applied");

                    }

                    System.out.println("Balance = "+c.credit);
                    cart.clear();

                }

            }

        }while(ch != 5);

    }
}