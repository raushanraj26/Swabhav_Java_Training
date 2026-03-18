package com.monocept.LibraryBook.test;

import java.util.TreeSet;

import com.monocept.LibraryBook.model.*;

public class BookTest {

    public static void main(String[] args) {

        // Step 1: Create TreeSet with Comparator
    	TreeSet<Book> books = new TreeSet<>(new BookTitleComparator());

        // Step 2: Add Academic Books
        books.add(new AcademicBook(101, "Java", "ABC", "CS", 1));
        books.add(new AcademicBook(102, "Python", "XYZ", "CS", 2));
        books.add(new AcademicBook(101, "Java", "ABC", "CS", 1)); // duplicate

        // Step 3: Add Magazine Books
        books.add(new MegazineBook(201, "Tech", "Author1", Month.JAN));
        books.add(new MegazineBook(202, "AI", "Author2", Month.FEB));
        books.add(new AcademicBook(103, "Python", "XYZ", "CS", 2));
        books.add(new AcademicBook(103, "P", "YZ", "S", 2));
        // Step 4: Display Books
        System.out.println("===== Books in Library (Sorted) =====");

        for (Book b : books) {
            System.out.println(b.toString());
        }
    }
}
