import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        Admin ad = new Admin("Admin","admin","123");
        Borrower br = new Borrower("User","user","123");
        lib.users.add(ad);
        lib.users.add(br);
        lib.books.add(new Book("Java","101",5,500));
        lib.books.add(new Book("Python","102",3,400));
        while(true){
            System.out.println("1.Login 2.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                String email=sc.next();
                String pass=sc.next();
                User current=null;
                for(User u:lib.users){
                    if(u.login(email,pass)){
                        current=u;
                    }
                }
                if(current==null){
                    System.out.println("Invalid Login");
                }
                else if(current instanceof Admin){
                    adminMenu(sc,lib,(Admin)current);
                }
                else if(current instanceof Borrower){
                    borrowerMenu(sc,lib,(Borrower)current);
                }
            }
            else if(ch==2){
                System.out.println("Exiting");
                break;
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
    }

    static void adminMenu(Scanner sc,Library lib,Admin ad){
        while(true){
            System.out.println("1.Add Book 2.View 3.Sort 4.Search 5.Reports 6.Logout");
            int ch=sc.nextInt();
            if(ch==1){
                String name=sc.next();
                String isbn=sc.next();
                int qty=sc.nextInt();
                double cost=sc.nextDouble();
                if(lib.searchByISBN(isbn)==null){
                    ad.addBook(lib,new Book(name,isbn,qty,cost));
                    System.out.println("Book Added");
                }
                else{
                    System.out.println("Book Exists");
                }
            }
            else if(ch==2){
                lib.viewBooks();
            }
            else if(ch==3){
                lib.sortByName();
                lib.sortByQuantity();
                System.out.println("Sorted");
            }
            else if(ch==4){
                String isbn=sc.next();
                Book b=lib.searchByISBN(isbn);
                if(b!=null){
                    System.out.println(b);
                }
                else{
                    System.out.println("Not Found");
                }
            }
            else if(ch==5){
                lib.lowStock();
                lib.neverBorrowed();
                lib.heavilyBorrowed();
                lib.pendingStudents();
            }
            else if(ch==6){
                System.out.println("Logged out");
                break;
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
    }

    static void borrowerMenu(Scanner sc,Library lib,Borrower br){
        while(true){
            System.out.println("1.View 2.Add Cart 3.Remove Cart 4.Checkout 5.Return 6.Extend 7.Lost 8.Card Lost 9.History 10.Logout");
            int ch=sc.nextInt();
            if(ch==1){
                lib.viewBooks();
            }
            else if(ch==2){
                String isbn=sc.next();
                Book b=lib.searchByISBN(isbn);
                if(b!=null){
                    br.cart.add(b);
                    System.out.println("Added to cart");
                }
                else{
                    System.out.println("Book not found");
                }
            }
            else if(ch==3){
                String isbn=sc.next();
                br.cart.removeIf(b->b.isbn.equals(isbn));
                System.out.println("Removed from cart");
            }
            else if(ch==4){
                lib.checkout(br);
                System.out.println("Checkout complete");
            }
            else if(ch==5){
                String isbn=sc.next();
                String date=sc.next();
                LocalDate returnDate=LocalDate.parse(date);
                lib.returnBook(br,isbn,returnDate);
                System.out.println("Returned");
            }
            else if(ch==6){
                String isbn=sc.next();
                lib.extend(br,isbn);
                System.out.println("Extended");
            }
            else if(ch==7){
                String isbn=sc.next();
                Book b=lib.searchByISBN(isbn);
                if(b!=null){
                    lib.lostBook(br,b);
                    System.out.println("Marked lost");
                }
            }
            else if(ch==8){
                lib.cardLost(br);
                System.out.println("Card lost recorded");
            }
            else if(ch==9){
                System.out.println(br.fineHistory);
                System.out.println(br.borrowHistory);
            }
            else if(ch==10){
                System.out.println("Logged out");
                break;
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
    }
}