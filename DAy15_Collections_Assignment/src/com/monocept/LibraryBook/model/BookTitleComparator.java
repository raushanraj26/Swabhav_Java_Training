package com.monocept.LibraryBook.model;
import java.util.Comparator;
public class BookTitleComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {


//        if (b1.getId() == b2.getId()) {
//            return 0;
//        }

        // Sort by title
        int titleCompare = b1.getTitle().compareTo(b2.getTitle());

        if (titleCompare != 0) {
            return titleCompare;
        }

        //  If title same → sort by ID
        return b1.getId() - b2.getId();
}}
