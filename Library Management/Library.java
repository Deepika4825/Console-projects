import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
class Library {
    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();
    Book searchByISBN(String isbn) {
        for (Book b : books) {
            if (b.isbn.equals(isbn)) {
                return b;
            }
        }
        return null;
    }
    List<Book> searchByName(String name) {
        List<Book> res = new ArrayList<>();

        for (Book b : books) {
            if (b.name.equalsIgnoreCase(name)) {
                res.add(b);
            }
        }
        return res;
    }
    void sortByName() {
        books.sort((a, b) -> {
            return a.name.compareTo(b.name);
        });
    }
    void sortByQuantity() {
        books.sort((a, b) -> {
            return a.quantity - b.quantity;
        });
    }
    void viewBooks() {
        for (Book b : books) {
            System.out.println(b.name + " | " + b.isbn + " | " + b.quantity);
        }
    }
    void checkout(Borrower br) {
        for (Book b : br.cart) {
            if (!br.canBorrow()) {
                break;
            }
            if (b.quantity > 0 && !alreadyBorrowed(br, b)) {
                Transaction t = new Transaction(b);
                br.borrowed.add(t);
                b.quantity--;
                b.borrowCount++;
                br.borrowHistory.add(b.name);
            }
        }
        br.cart.clear();
    }
    boolean alreadyBorrowed(Borrower br, Book b) {
        for (Transaction t : br.borrowed) {
            if (t.book == b) {
                return true;
            }
        }
        return false;
    }
    void returnBook(Borrower br, String isbn, LocalDate returnDate) {
        for (Transaction t : br.borrowed) {
            if (t.book.isbn.equals(isbn)) {
                long days = ChronoUnit.DAYS.between(t.borrowDate, returnDate);
                double fine = calculateFine(days, t.book.cost);
                if (fine > 0) {
                    br.deposit -= fine;
                    br.fineHistory.add("Late fine: " + fine);
                }
                t.book.quantity++;
                br.borrowed.remove(t);
                break;
            }
        }
    }
    double calculateFine(long days, double cost) {
        if (days <= 15) {
            return 0;
        }
        long extra = days - 15;
        double fine = extra * 2;
        if (extra > 10) {
            fine = fine * 2;
        }
        return Math.min(fine, 0.8 * cost);
    }
    void lostBook(Borrower br, Book b) {
        double fine = 0.5 * b.cost;
        br.deposit -= fine;
        br.fineHistory.add("Lost book fine: " + fine);
    }
    void cardLost(Borrower br) {
        br.deposit -= 10;
        br.fineHistory.add("Card lost fine: 10");
    }
    void extend(Borrower br, String isbn) {
        for (Transaction t : br.borrowed) {
            if (t.book.isbn.equals(isbn)) {
                if (t.extensions < 2) {
                    t.extensions++;
                    t.borrowDate = t.borrowDate.plusDays(15);
                }
            }
        }
    }
    void lowStock() {
        for (Book b : books) {
            if (b.quantity < 2) {
                System.out.println(b.name);
            }
        }
    }
    void neverBorrowed() {
        for (Book b : books) {
            if (b.borrowCount == 0) {
                System.out.println(b.name);
            }
        }
    }
    void heavilyBorrowed() {
        books.sort((a, b) -> {
            return b.borrowCount - a.borrowCount;
        });
        for (Book b : books) {
            System.out.println(b.name + " -> " + b.borrowCount);
        }
    }
    void pendingStudents() {
        for (User u : users) {
            if (u instanceof Borrower) {
                Borrower b = (Borrower) u;
                if (!b.borrowed.isEmpty()) {
                    System.out.println(b.name);
                }
            }
        }
    }
    void bookStatus(String isbn) {
        for (User u : users) {
            if (u instanceof Borrower) {
                Borrower br = (Borrower) u;
                for (Transaction t : br.borrowed) {
                    if (t.book.isbn.equals(isbn)) {
                        System.out.println("Borrowed by: " + br.name);
                        System.out.println("Return date: " + t.borrowDate.plusDays(15));
                    }
                }
            }
        }
    }
}