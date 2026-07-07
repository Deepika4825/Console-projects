class Admin extends User {
    Admin(String n, String e, String p) {
        super(n, e, p);
    }
    void addBook(Library lib, Book b) {
        lib.books.add(b);
    }
    void deleteBook(Library lib, String isbn) {
        lib.books.removeIf(b -> b.isbn.equals(isbn));
    }
    void updateBook(Library lib, String isbn, int qty) {
        for (Book b : lib.books) {
            if (b.isbn.equals(isbn)) b.quantity = qty;
        }
    }
    void addUser(Library lib, User u) {
        lib.users.add(u);
    }
}