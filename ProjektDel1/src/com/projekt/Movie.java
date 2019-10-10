package com.projekt;

public class Movie extends Entertainment{
    private String movieLength;

    public Movie(String name, String genre, String year, String rating, String movieLength) {
        super(name, genre, year, rating);
        this.movieLength = movieLength;
    }

    public String getMovieLength() { return movieLength; }
    public void setMovieLength(String movieLength) { this.movieLength = movieLength; }

    public static void printMenuMovie() {
        System.out.println("--------->MOVIE MENU<---------");
        System.out.println("0. Show Movie Menu");
        System.out.println("1. list");
        System.out.println("2. Add a Movie");
        System.out.println("3. Add a movie to Favorites");
        System.out.println("4. Remove a movie");
        System.out.println("5. Find a movie");
        System.out.println("6. Edit a movie");
        System.out.println("7. Back");
        System.out.println("--------------<>--------------");
    }

    public static Movie createMovie (String name, String genre, String year, String rating, String movieLength) {
        return new Movie (name, genre, year, rating, movieLength);
    }

}
