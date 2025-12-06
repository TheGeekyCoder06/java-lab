class Book {
    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Constructor with title and author
    Book(String t, String a) {
        title = t;
        author = a;
        price = 0.0;
    }

    // Constructor with title, author and price
    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price);
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book();
        System.out.println("After default constructor:");
        b1.display();

        Book b2 = new Book("Java Programming", "James Gosling");
        System.out.println("After constructor(title, author):");
        b2.display();

        Book b3 = new Book("OOP in Java", "Herbert Schildt", 599.50);
        System.out.println("After constructor(title, author, price):");
        b3.display();
    }
}
