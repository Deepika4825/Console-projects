class Book {
    String name, isbn;
    int quantity;
    double cost;
    int borrowCount = 0;
    Book(String name, String isbn, int quantity, double cost) {
        this.name = name;
        this.isbn = isbn;
        this.quantity = quantity;
        this.cost = cost;
    }
}