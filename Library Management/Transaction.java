import java.time.LocalDate;
class Transaction {
    Book book;
    LocalDate borrowDate;
    LocalDate returnDate;
    int extensions = 0;
    Transaction(Book book) {
        this.book = book;
        this.borrowDate = LocalDate.now();
    }
}