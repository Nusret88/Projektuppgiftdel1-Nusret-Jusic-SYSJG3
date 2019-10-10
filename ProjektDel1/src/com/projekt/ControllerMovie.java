package com.projekt;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerMovie {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList <Movie> movieList;
    private static ControllerMovie controllerMovie = new ControllerMovie ();

    public ControllerMovie() { this.movieList = new ArrayList<Movie>(); }

    public static void menueMovie () {
        Movie.printMenuMovie();
        boolean back2 = false;

        while (!back2) {
            int choices = scanner.nextInt();
            scanner.nextLine();
            switch (choices) {
                case 0:
                    Movie.printMenuMovie();
                    break;
                case 1:
                    controllerMovie.PrintMovies();
                    break;
                case 2:
                    ProjektDel1.addNewMovie();
                    break;
                case 3:
                    ProjektDel1.addFavoriteMovie();
                    break;
                case 4:
                    ProjektDel1.RemoveMovie();
                    break;
                case 5:
                    ProjektDel1.searchMovie();
                    break;
                case 6:
                    ProjektDel1.EditMovie();
                    break;
                case 7:
                    ProjektDel1.MainMenu();
                    back2 = true;
                    break;
            }
        }
    }

     public boolean addNewMovie (Movie movie) {
        if (findMovie(movie.getName()) >= 0) {
            System.out.println("Movie already exists in the list.");
            return false; }
         movieList.add(movie);
         System.out.println("\nMovie has been added");
         return true; }

private int findMovie (Movie movie) { return this.movieList.indexOf(movie); }
private int findMovie (String movieName) {
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getName().equals(movieName)) {
                return i;
            }
        }
        return -1;
}

    public String searchMovie (Movie movie) {
        if (findMovie(movie) >= 0) {
            return movie.getName();
        }
        return null;
    }
    public Movie searchMovie (String name) {
        int position = findMovie(name);
        if (position >= 0) {
            return this.movieList.get(position);
        }
        return null;
    }

    public boolean EditMovie (Movie oldMovie, Movie newMovie) {
        int position = findMovie(oldMovie);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.movieList.set(position, newMovie);
    return true; }

    public boolean RemoveGame (Movie movie) {
        int position = findMovie(movie);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.movieList.remove(movie);
        return true; }

public void PrintMovies () {
    System.out.println("----------->MOVIES<-----------");
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i+1) + ". " +
                    this.movieList.get(i).getName() + "\n\tGanre: " +
                    this.movieList.get(i).getGenre() + "\n\tRelease date: " +
                    this.movieList.get(i).getYear() + "\n\tRating: " +
                    this.movieList.get(i).getRating() + "/10\n\tLength: " +
                    this.movieList.get(i).getMovieLength()); }
    System.out.println("-------------<>--------------");
}

public void RandomMovie () {
    if (movieList.isEmpty()) {
        System.out.println("The Movie list is empty");
    } else {
    int position = (int) (Math.random() * movieList.size());
    System.out.println("----------->RANDOM<-----------");
    System.out.println(
            "Name: " +
                    this.movieList.get(position).getName() + "\n\tGanre: " +
                    this.movieList.get(position).getGenre() + "\n\tRelease date: " +
                    this.movieList.get(position).getYear() + "\n\tRating: " +
                    this.movieList.get(position).getRating() + "/10");
    System.out.println("----------->MOVIE<-----------"); } }








}
