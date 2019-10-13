package com.projekt;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerMovie {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList <Movie> movieList;
    private static ControllerMovie controllerMovie = new ControllerMovie ();

    public ControllerMovie() { this.movieList = new ArrayList<Movie>(); }
    /**
     * En metod som består av en meny gjord med Switch och loopas så länge back2 är falsk.
     */
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
    /**
     * Kollar efter ett favorite med findMovie metoden i movieList och om det finns returnerar den false.
     * Om den inte finns så returnerar den true där en .add körs för movieList och lägger till ett inlägg.
     * @param movie Denna parametern representerar det som söks i listan.
     * @return Om getName finns i listan returneras false annars returneras true.
     */
     public boolean addNewMovie (Movie movie) {
        if (findMovie(movie.getName()) >= 0) {
            System.out.println("Movie already exists in the list.");
            return false; }
         movieList.add(movie);
         System.out.println("\nMovie has been added");
         return true; }
    /** Denna metod returnerar index av det som söks.
     * @param movie Denna parametern representerar det som söks i listan.
     * @return skickar tillbaka indexen av favorite.
     */
private int findMovie (Movie movie) { return this.movieList.indexOf(movie); }
    /** letar igenom hela listan med hjälp av en for loop för att se om det finns ett namn i
     * listan som är likadant som det inskrivna namnet för att returnera positionen av det.
     * @param movieName Denna parametern representerar det som kommer sökas efter i listan.
     * @return om det sökta namnet existerar returneras nummret inuti i som representerar positinen i listan.
     * Annars returneras -1 vilket inte existerar i listan eftersom arraylistor börjar från 0.
     */
private int findMovie (String movieName) {
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getName().equals(movieName)) {
                return i;
            }
        }
        return -1;
}
    /**
     *Metoden använder findMovie metoden för att se om det sökta namnet finns i listan
     * och om det finns returneras namnet med .getName().
     * @param movie Denna parametern representerar det som söks i listan.
     * @return Om det som söks efter finns returneras namnet annars returneras null.
     */
    public String searchMovie (Movie movie) {
        if (findMovie(movie) >= 0) {
            return movie.getName();
        }
        return null;
    }
    /**
     * Metoden använder sig av findMovie metoden för att se om namned som söks existerar i listan och om det gör
     * så sparas nummret av positionen i en int variabel som sedan returneras med hjälp av get. Om inget hittas returneras null.
     * @param name Denna parametern representerar namnet som söks i listan.
     * @return returnerar positionen i listan av det inskrivna namnet om det inte hittas returneras null.
     */
    public Movie searchMovie (String name) {
        int position = findMovie(name);
        if (position >= 0) {
            return this.movieList.get(position);
        }
        return null;
    }
    /**
     * En metod som använder sig av findMovie metoden för att hitta positionen som ska ersättas med ny information.
     * @param oldMovie Parametern representerar namnet på det som ska ersättas.
     * @param newMovie Parametern representerar det nya inlägget som ersätter det gammla.
     * @return om ingen film hittas returneras false tillsammans med medelandet "Does not exist"
     * om det hittas används .set för att ersätta den gammla informationen med ny på samma position.
     */
    public boolean EditMovie (Movie oldMovie, Movie newMovie) {
        int position = findMovie(oldMovie);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.movieList.set(position, newMovie);
    return true; }
    /**
     *  En metod som använder sig av findMovie metoden för att kolla efter det användaren söker efter för att sedan
     *  ta bort den positionen i listan med .remove.
     * @param movie Parametern representerar det som ska tas bort.
     * @return använder .remove för att ta bort den hittade positionen med all information som fanns där.
     */
    public boolean RemoveMovie (Movie movie) {
        int position = findMovie(movie);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.movieList.remove(movie);
        return true; }
    /**
     * En simpel metod som använder en for loop för att printa ut all information för alla element som existerar i listan.
     */
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
    /**
     * printar ut ett slumpmässigt val ur movieList, om listan är tom får användaren svaret "The Movie list is empty".
     */
public void RandomMovie () {
    if (movieList.isEmpty()) {
        System.out.println("The Movie list is empty");
        System.out.println("-------------><--------------");
        System.out.println("0. Show main menu");
        System.out.println("-------------<>--------------");
    } else {
    int position = (int) (Math.random() * movieList.size());
    System.out.println("----------->RANDOM<-----------");
    System.out.println(
            "Name: " +
                    this.movieList.get(position).getName() + "\n\tGanre: " +
                    this.movieList.get(position).getGenre() + "\n\tRelease date: " +
                    this.movieList.get(position).getYear() + "\n\tRating: " +
                    this.movieList.get(position).getRating() + "/10");
    System.out.println("----------->MOVIE<-----------");
        System.out.println("0. Show main menu");
        System.out.println("-------------<>--------------");}
}








}
