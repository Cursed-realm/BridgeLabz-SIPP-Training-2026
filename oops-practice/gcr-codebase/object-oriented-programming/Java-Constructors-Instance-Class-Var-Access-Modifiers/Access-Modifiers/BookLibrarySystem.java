// Section 3 – Problem 2: Book Library System
// Demonstrates: public ISBN, protected title, private author + EBook subclass

class LibraryBook {
    public    String ISBN;    // accessible everywhere
    protected String title;   // accessible in same package + subclasses
    private   String author;  // accessible only within LibraryBook

    LibraryBook(String ISBN, String title, String author) {
        this.ISBN   = ISBN;
        this.title  = title;
        this.author = author;
    }

    // Public getter for private author
    public String getAuthor() {
        return author;
    }

    // Public setter for private author
    public void setAuthor(String author) {
        this.author = author;
    }

    public void display() {
        System.out.println("ISBN: " + ISBN
                         + " | Title: " + title
                         + " | Author: " + author);
    }
}

class EBook extends LibraryBook {
    String downloadURL;
    int    fileSizeMB;

    EBook(String ISBN, String title, String author, String downloadURL, int fileSizeMB) {
        super(ISBN, title, author);
        this.downloadURL = downloadURL;
        this.fileSizeMB  = fileSizeMB;
    }

    @Override
    public void display() {
        // ISBN   → public    : directly accessible ✓
        // title  → protected : accessible in subclass ✓
        // author → private   : NOT directly accessible, use getAuthor() ✓
        System.out.println("EBook"
                         + " | ISBN: " + ISBN
                         + " | Title: " + title
                         + " | Author: " + getAuthor()
                         + " | URL: " + downloadURL
                         + " | Size: " + fileSizeMB + " MB");
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        LibraryBook book = new LibraryBook(
                "978-0-13-468599-1", "Effective Java", "J. Bloch");
        System.out.println("-- Library Book --");
        book.display();

        book.setAuthor("Joshua Bloch");   // update private field via setter
        System.out.println("Updated Author: " + book.getAuthor());

        System.out.println("\n-- EBook (subclass) --");
        EBook ebook = new EBook(
                "978-0-59-651798-1",
                "Head First Java",
                "Kathy Sierra",
                "https://example.com/hfj.pdf",
                25);
        ebook.display();
    }
}
