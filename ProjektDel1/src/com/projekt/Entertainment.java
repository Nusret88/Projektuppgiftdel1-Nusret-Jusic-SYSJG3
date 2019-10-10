package com.projekt;



public class Entertainment {
    private static ControllerGame controllerGame = new ControllerGame ();
    private static ControllerMovie controllerMovie = new ControllerMovie ();
    private static ControllerMusic controllerMusic = new ControllerMusic ();

    private String name;
    private String genre;
    private String year;
    private String rating;

    public Entertainment(String name, String genre, String year, String rating) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    /**
     * RandomPick slumpar mellan 1-3 och beroende på vilket nummer som väljs så kör den
     * en random pick metod i en av game, movie och music listorna som väljer ett inlägg
     * och skriver sedan ut den information för det.
     */
    public static void RandomPick () {
        int pick = (int) (1 + Math.random() * 3);
        if (pick == 1) {
             controllerGame.RandomGame(); }
        if (pick == 2) {
             controllerMovie.RandomMovie(); }
        if (pick == 3) {
             controllerMusic.RandomMusic(); }
    }

    public static void printMainManu() {
    System.out.println("----------MAIN MENU----------");
    System.out.println("0. Show main Menu");
    System.out.println("1. Game list");
    System.out.println("2. Movie list");
    System.out.println("3. Music list");
    System.out.println("4. Favorite list");
    System.out.println("5. Random Pick");
    System.out.println("6. Exit");
    System.out.println("-----------------------------");
    }


}
