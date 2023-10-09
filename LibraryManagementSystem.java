package LabAssignment1;

import java.util.ArrayList;
import java.util.Scanner;
public class LibraryManagementSystem {
    private final static ArrayList<Book> library = new ArrayList<>();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search for a Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> searchBook();
                case 5 -> displayBooks();
                case 6 -> {
                    System.out.println("Exiting the system.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        Book newBook = new Book(title, author);
        library.add(newBook);

        System.out.println("Book added successfully.");
    }

    private static void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String titleToBorrow = scanner.nextLine();

        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(titleToBorrow) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("You have borrowed the book: " + book.getTitle());
                return;
            }
        }

        System.out.println("Book not found or already borrowed.");
    }

    private static void returnBook() {
        System.out.print("Enter book title to return: ");
        String titleToReturn = scanner.nextLine();

        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(titleToReturn) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("You have returned the book: " + book.getTitle());
                return;
            }
        }

        System.out.println("Book not found or already returned.");
    }

    private static void searchBook() {
        System.out.print("Enter book title or author: ");
        String query = scanner.nextLine();

        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                System.out.println("Book found: " + book);
                return;
            }
        }

        System.out.println("Book not found.");
    }

    private static void displayBooks() {
        if (library.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Library Books:");
            for (Book book : library) {
                System.out.println(book);
            }
        }
    }
}
