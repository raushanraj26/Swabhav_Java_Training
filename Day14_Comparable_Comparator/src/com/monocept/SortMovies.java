package com.monocept;

import java.util.*;

public class SortMovies {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Movie> movies = new ArrayList<>();

        System.out.print("Enter number of movies: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter movie details " + (i+1));

            System.out.print("Enter title: ");
            String title = sc.nextLine();

            System.out.print("Enter year: ");
            int year = sc.nextInt();
            sc.nextLine();

            movies.add(new Movie(title, year));
        }

        // Sorting
        Collections.sort(movies, new MovieComparator());

        System.out.println("\nMovies Sorted:");

        for(Movie m : movies) {
            System.out.println(m);
        }

        sc.close();
    }
}

/* Movie Class */
class Movie {

    private String title;
    private int year;

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return title + " - " + year;
    }
}


class MovieComparator implements Comparator<Movie> {

    public int compare(Movie m1, Movie m2) {

        //  descending
        int yearCompare = m2.getYear() - m1.getYear();

        if(yearCompare != 0) {
            return yearCompare;
        }

        // If same year sort by title ascending
        return m1.getTitle().compareTo(m2.getTitle());
    }
}