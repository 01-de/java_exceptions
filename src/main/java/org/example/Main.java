package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Library by 01-de");
            System.out.println("1: Add new book");
            System.out.println("2: List of all books");
            System.out.println("3: Take the book");
            System.out.println("4: Return the book");
            System.out.println("5: Exit");

            String option = sc.nextLine();
            int choice = Integer.parseInt(option);

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Add new book menu:");
                        System.out.println("Type title: ");
                        String title = sc.nextLine();
                        System.out.println("Type author: ");
                        String author = sc.nextLine();
                        System.out.println("Enter available copies: ");
                        int availableCopies = Integer.parseInt(sc.nextLine());
                        if (availableCopies < 0) {
                            System.out.println("Error: quantity must be non-negative.");
                        }
                        library.addBook(new Book(title, author, availableCopies));
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter an integer for quantity.");
                    }
                    break;

                case 2:
                    System.out.println("List of all books menu:");
                    library.getAllBooks();
                    break;

                case 3:
                    System.out.println("Take a book menu:");
                    System.out.println("Search by title: ");
                    String query = sc.nextLine();
                    try {
                        library.takeBook(query);
                    } catch (ItemNotFoundedException | NoAvailableException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    String title = sc.nextLine();
                    try {
                        library.returnBook(title);
                    } catch (ItemNotFoundedException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exit...");
                    return;

                default:
                    System.out.println("Invalid option please choose between 1-5");

            }
        }
    }
}