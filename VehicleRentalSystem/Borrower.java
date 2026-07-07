public class Borrower extends User {

    double securityDeposit = 30000;

    public Borrower(String email, String password) {
        super(email, password);
    }
}