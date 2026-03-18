package com.monocept;

import java.util.*;

public class SortMovies {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Movie> movies = new ArrayList<>();

        int n = 0;

        // ✅ Validate number of movies
        while (true) {
            System.out.print("Enter number of movies: ");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();

                if (n > 0) {
                    break;
                } else {
                    System.out.println("Number must be greater than 0!");
                }
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
            }
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter movie details " + (i+1));

            // ✅ Validate Title
            String title;
            while (true) {
                System.out.print("Enter title: ");
                title = sc.nextLine();

                if (!title.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Title cannot be empty!");
                }
            }

            // ✅ Validate Year
            int year;
            while (true) {
                System.out.print("Enter year: ");

                if (sc.hasNextInt()) {
                    year = sc.nextInt();
                    sc.nextLine();

                    if (year >= 1888 && year <= currentYear) {
                        break;
                    } else {
                        System.out.println("Enter valid year (1888 - " + currentYear + ")");
                    }
                } else {
                    System.out.println("Invalid input! Enter a number.");
                    sc.nextLine();
                }
            }

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