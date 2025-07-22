package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> catalog = new ArrayList<>();

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void takeBook(String title) throws ItemNotFoundedException, NoAvailableException {
        boolean status = false;
        for (Book b : catalog) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (b.getAvailableCopies() == 0) {
                    throw new NoAvailableException("No available copies for now sorry");
                }
                System.out.println(b.getTitle() + " successfully has been taken");
                int availableCopies = b.getAvailableCopies();
                availableCopies--;
                b.setAvailableCopies(availableCopies);
                status = true;
            }
        }
        if (!status) {
            throw new ItemNotFoundedException("Unfortunately " + title + " not founded.");
        }
    }

    public void returnBook(String title) throws ItemNotFoundedException {
        boolean status = false;
        for (Book b : catalog) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                int availableCopies = b.getAvailableCopies();
                availableCopies++;
                b.setAvailableCopies(availableCopies);
                System.out.println("This " + b.getTitle() + " successfully returned.");
                status = true;
            }
        }
        if (!status) {
            throw new ItemNotFoundedException("Unfortunately " + title + " not founded.");
        }
    }

    public void getAllBooks() {
        if (catalog.isEmpty()) {
            System.out.println("Catalog is empty.");
        } else {
            for (Book b : catalog) {
                System.out.println(b);
            }
        }
    }
}
