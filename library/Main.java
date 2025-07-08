package library;

import java.util.Scanner;

public class Main {
    private static final Library lib = new Library();
    private static final Scanner sc  = new Scanner(System.in);

    public static void main(String[] args) {
        seedSampleData();
        while (true) {
            showMenu();
            switch (sc.nextLine().trim()) {
                case "1" -> lib.listBooks().forEach(System.out::println);
                case "2" -> lib.listMembers().forEach(System.out::println);
                case "3" -> handleLend();
                case "4" -> handleReturn();
                case "5" -> {
                    System.out.println("Loans:");
                    lib.listLoans().forEach(System.out::println);
                }
                case "6" -> handleAddBook();
                case "7" -> handleAddMember();

                case "0" -> { System.exit(0); }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("""
            === Little Lemon Library ===
1. List books
2. List members
3. Lend a book
4. Return a book
5. View loans
6. Add a new book
7. Add a new member
0. Exit

            """);
        System.out.print("Choice: ");
    }

    private static void handleLend() {
        System.out.print("Book ID: ");
        int bId = Integer.parseInt(sc.nextLine());
        System.out.print("Member ID: ");
        int mId = Integer.parseInt(sc.nextLine());
        if (lib.lendBook(bId, mId))
            System.out.println("Book loaned successfully.");
        else
            System.out.println("Could not lend book.");
    }

    private static void handleReturn() {
        System.out.print("Book ID to return: ");
        int bId = Integer.parseInt(sc.nextLine());
        if (lib.returnBook(bId))
            System.out.println("Returned successfully.");
        else
            System.out.println("Book not found or not on loan.");
    }

    private static void seedSampleData() {
    lib.addBook(new Book(1, "Clean Code", "Robert C. Martin"));
    lib.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
    lib.addBook(new Book(3, "Design Patterns", "Erich Gamma"));
    lib.addBook(new Book(4, "The Pragmatic Programmer", "Andy Hunt"));

    lib.addMember(new Member(1, "Emma Torres", "emma@example.com"));
    lib.addMember(new Member(2, "Liam Patel", "liam@example.com"));
    lib.addMember(new Member(3, "Noah Lee",   "noah@example.com"));
    lib.addMember(new Member(4, "Olivia Kim", "olivia@example.com"));
}

private static void handleAddBook() {
    System.out.print("New Book ID: ");
    int id = Integer.parseInt(sc.nextLine());
    System.out.print("Title: ");
    String title = sc.nextLine();
    System.out.print("Author: ");
    String author = sc.nextLine();

    lib.addBook(new Book(id, title, author));
    System.out.println("Book added.");
}

private static void handleAddMember() {
    System.out.print("New Member ID: ");
    int id = Integer.parseInt(sc.nextLine());
    System.out.print("Name: ");
    String name = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();

    lib.addMember(new Member(id, name, email));
    System.out.println("Member added.");
}

}
