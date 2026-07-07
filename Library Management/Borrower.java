import java.util.*;
class Borrower extends User {
    List<Transaction> borrowed = new ArrayList<>();
    List<Book> cart = new ArrayList<>();
    List<String> fineHistory = new ArrayList<>();
    List<String> borrowHistory = new ArrayList<>();
    double deposit = 1500;
    Borrower(String n, String e, String p) {
        super(n, e, p);
    }
    boolean canBorrow() {
        return borrowed.size() < 3 && deposit >= 500;
    }
}