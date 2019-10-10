package com.projekt;

import java.util.Scanner;

public class ProjektDel1 {

    private static Scanner scan = new Scanner(System.in);
    private static ControllerGame controllerGame = new ControllerGame ();
    private static ControllerMovie controllerMovie = new ControllerMovie ();
    private static ControllerMusic controllerMusic = new ControllerMusic ();
    private static ControllerFavorite controllerFavorite = new ControllerFavorite ();

    /** Meny för att ta sig in till andra menyer med listor
     * där man kan skapa inlägg i listorna och spara sina favoriter i favorit listan
     *
     * @author Nusret Jusic
     * @version 1.0
     * @since   2019-10-08
     */

    public static void main(String[] args) {
ProjektDel1.MainMenu();

    }

    public static void MainMenu () {
        boolean exit = false;
        int choices;
        Entertainment.printMainManu();
        while (!exit) {
            choices = scan.nextInt();
            scan.nextLine();
            switch (choices) {
                case 0:
                    Entertainment.printMainManu();
                    break;
                case 1:
                    ControllerGame.menuGames();
                    exit = true;
                    break;
                case 2:
                    ControllerMovie.menueMovie();
                    exit = true;
                    break;
                case 3:
                    ControllerMusic.menueMusic();
                    exit = true;
                    break;
                case 4:
                    ControllerFavorite.menuFavorite();
                    exit = true;
                    break;
                case 5:
                   Entertainment.RandomPick();
                    break;
                case 6:
                    System.out.println("<BYE!>");
                    exit = true;
                    break;
            }
        }
    }

    /**
     * addNewGame, addNewMovie och addNewMusic lägger till ett inlägg i respective lista
     * med information. Alla tre listorna har 4 variabler gemensamt med en eller två unika för
     * sin lista. Rating är alltid i int och konverteras till String senare för att kunna tvinga
     * valet av 1-10 i listan, om svaret är högre skrivs 10 in som max och om svaret är mindre än 1 skrivs 1 in.
     * Om användaren skriver in ett String svar så krashar programmet.
     */
    public static void addNewGame () {
        System.out.print("\nGame name: ");
        String name = scan.nextLine();
        System.out.print("\nGame ganre: ");
        String genre = scan.nextLine();
        System.out.print("\nGame release date: ");
        String year = scan.nextLine();
        System.out.print("\nRate the game (1 lowest and 10 max): ");
       int rating = scan.nextInt();

        if (rating >= 10) {
            rating = 10;
        }
        if (rating <= 0) {
            rating = 1;
        }
        scan.nextLine();

        System.out.print("\nWhat is the name of the Developers?: ");
        String devname = scan.nextLine();
        System.out.print("\nWhat gaming platform is the game on?: ");
        String platform = scan.nextLine();

        Game newGame = Game.createGame(name, genre, year, Integer.toString(rating), devname, platform);
        if (controllerGame.addNewGame(newGame)) {
            System.out.println("Namn: " + name +
                    " \nGenre: " + genre +
                    " \nRelease date: " + year +
                    " \nRating: " + rating + "/10" +
                    " \nDeveloper name: " + devname +
                    " \nGame platform: " + platform);
            System.out.println("-------------<>--------------\n\n");
        } else {
            System.out.println(name + " already exist.");
        }
        System.out.println("-------------><--------------");
        System.out.println("0. Show game menu");
        System.out.println("-------------<>--------------");
    }

    public static void addNewMovie () { // loopar i all oändlighet
        System.out.print("\nNovie name: ");
        String name = scan.nextLine();
        System.out.print("\nMovie ganre: ");
        String genre = scan.nextLine();
        System.out.print("\nMovie release date: ");
        String year = scan.nextLine();
        System.out.print("\nRate the movie (1 lowest and 10 max): ");
        int rating = scan.nextInt();
        if (rating >= 10) {
            rating = 10;
        }
        if (rating <= 0) {
            rating = 1;
        }
        scan.nextLine();

        System.out.print("\nWhat is the length of the movie?: ");
        String length = scan.nextLine();

        Movie newMovie = Movie.createMovie(name, genre, year, Integer.toString(rating), length);
        if (controllerMovie.addNewMovie(newMovie)) {
            System.out.println("Namn: " + name +
                    " \nGenre: " + genre +
                    " \nRelease date: " + year +
                    " \nRating: " + rating + "/10" +
                    " \nLength: " + length);
            System.out.println("-------------<>--------------\n\n");
        } else {
            System.out.println(name + " already exist.");
        }
        System.out.println("-------------><--------------");
        System.out.println("0. Show movie menu");
        System.out.println("-------------<>--------------");
    }

    public static void addNewMusic () {
        System.out.print("\nSinger/ band name: ");
        String name = scan.nextLine();
        System.out.print("\nMusic ganre: ");
        String genre = scan.nextLine();
        System.out.print("\nMusic release date: ");
        String year = scan.nextLine();
        System.out.print("\nRate the music (1 lowest and 10 max): ");
        int rating = scan.nextInt();
        if (rating >= 10) {
            rating = 10;
        }
        if (rating <= 0) {
            rating = 1;
        }
        scan.nextLine();

        System.out.print("\nWhat album/ albums are there?: ");
        String album = scan.nextLine();
        System.out.print("\nHow many tracks are there?: ");
        String tracks = scan.nextLine();

        Music newMusic = Music.createMusic(name, genre, year, Integer.toString(rating), album, tracks);
        if (controllerMusic.addNewMusic(newMusic)) {
            System.out.println("Namn: " + name +
                    " \nGenre: " + genre +
                    " \nRelease date: " + year +
                    " \nRating: " + rating + "/10" +
                    " \nLength: " + album +
                    " \nTracks: " + tracks);
            System.out.println("-------------<>--------------\n\n");
        } else {
            System.out.println(name + " already exist.");
        }
        System.out.println("-------------><--------------");
        System.out.println("0. Show music menu");
        System.out.println("-------------<>--------------");
    }


    /**
     * Letar upp ett namn i gamesList och om det finns skickar den namn, genre, year och rating till favorites
     * tillsammans med en ny varibel som heter type och blir GAMES för spel, MOVIE för film och MUSIC för musik
     */
        public static void addFavoriteGame () {
            System.out.print("\nGame name: ");
            String name = scan.nextLine();
            Game existingGame = controllerGame.searchGame(name);
            if (existingGame == null) {
                System.out.println("Game not found");
                return;
            }
            String type = "GAME";
            String genre = existingGame.getGenre();
            String year = existingGame.getYear();
            String rating = existingGame.getRating();

            Favorite newFavorite = Favorite.createFavorite(type, name, genre, year, rating);

            if (controllerFavorite.addNewFavorite(newFavorite)) {
                System.out.println(type + "\nNamn: " + name +
                        ", \nGenre: " + genre +
                        ", \nRelease date: " + year +
                        ", \nRating: " + rating + "/10");
            } else {
                System.out.println("Couldn't add " + name + " because it already exist.");
            }
            System.out.println("-------------><--------------");
            System.out.println("0. Show game menu");
            System.out.println("-------------<>--------------");
        }
    public static void addFavoriteMovie () {
        System.out.print("\nMovie name: ");
        String name = scan.nextLine();
        Movie existingMovie = controllerMovie.searchMovie(name);
        if (existingMovie == null) {
            System.out.println("Movie not found");
            return;
        }
        String type = "MOVIE";
        String genre = existingMovie.getGenre();
        String year = existingMovie.getYear();
        String rating = existingMovie.getRating();

        Favorite newFavorite = Favorite.createFavorite(type, name, genre, year, rating);

        if (controllerFavorite.addNewFavorite(newFavorite)) {
            System.out.println(type + "\nNamn: " + name +
                    ", \nGenre: " + genre +
                    ", \nRelease date: " + year +
                    ", \nRating: " + rating + "/10");
        } else {
            System.out.println("Couldn't add " + name + " because it already exist.");
        }
        System.out.println("-------------><--------------");
        System.out.println("0. Show game menu");
        System.out.println("-------------<>--------------");
    }

    public static void addFavoriteMusic () {
        System.out.print("\nMusic name: ");
        String name = scan.nextLine();
        Music existingMusic = controllerMusic.searchMusic(name);
        if (existingMusic == null) {
            System.out.println("Music not found");
            return;
        }
        String type = "MUSIC";
        String genre = existingMusic.getGenre();
        String year = existingMusic.getYear();
        String rating = existingMusic.getRating();

        Favorite newFavorite = Favorite.createFavorite(type, name, genre, year, rating);

        if (controllerFavorite.addNewFavorite(newFavorite)) {
            System.out.println(type + "\nNamn: " + name +
                    ", \nGenre: " + genre +
                    ", \nRelease date: " + year +
                    ", \nRating: " + rating + "/10");
        } else {
            System.out.println("Couldn't add " + name + " because it already exist.");
        }
        System.out.println("-------------><--------------");
        System.out.println("0. Show game menu");
        System.out.println("-------------<>--------------");
    }



    /**
     * Söker upp ett spel och printar ut information om det
     */
        public static void searchGame() {
            System.out.println("Search for a game in the list");
            String name = scan.nextLine();
            Game existingGame = controllerGame.searchGame(name);
            if (existingGame == null) {
                System.out.println("Game not found");
            }
            System.out.println("-------------><--------------");
            System.out.println("\nName: " + existingGame.getName() +
                    "\n\tGenre: " + existingGame.getGenre()
                    + "\n\tRelease Date: " + existingGame.getYear()
                    + "\n\tRating: " + existingGame.getRating() + "/10"
                    + "\n\tDeveloper: " + existingGame.getDevName()
                    + "\n\tPlatform: " + existingGame.getPlatform());
            System.out.println("-------------<>--------------");

            //ersätta denna med en metod istället
            System.out.println("\n\n-------------><--------------");
            System.out.println("0. Show game menu");
            System.out.println("-------------<>--------------");
        }

    public static void searchMovie() {
        System.out.println("Search for a game in the list");
        String name = scan.nextLine();
        Movie existingMovie = controllerMovie.searchMovie(name);
        if (existingMovie == null) {
            System.out.println("Game not found");
        }
        System.out.println("\nName: " + existingMovie.getName() +
                "\n\tGenre: " + existingMovie.getGenre()
                + "\n\tRelease Date: " + existingMovie.getYear()
                + "\n\tRating: " + existingMovie.getRating() + "/10"
                + "\n\tDeveloper: " + existingMovie.getMovieLength());
    }

    public static void searchMusic() {
        System.out.println("Search for a music in the list");
        String name = scan.nextLine();
        Music existingMusic = controllerMusic.searchMusic(name);
        if (existingMusic == null) {
            System.out.println("Music not found");
        }
        System.out.println("\nName: " + existingMusic.getName() +
                "\n\tGenre: " + existingMusic.getGenre()
                + "\n\tRelease Date: " + existingMusic.getYear()
                + "\n\tRating: " + existingMusic.getRating() + "/10"
                + "\n\tAlbum: " + existingMusic.getAlbum()
                + "\n\tTracks: " + existingMusic.getTracks());
    }

    public static void searchFavorite() {
        System.out.println("Search for a game in the list");
        String name = scan.nextLine();
        Favorite existingFavorite = controllerFavorite.searchFavorite(name);
        if (existingFavorite == null) {
            System.out.println("Game not found");
        }
        System.out.println("\nName: " + existingFavorite.getName() +
                "\n\tGenre: " + existingFavorite.getGenre()
                + "\n\tRelease Date: " + existingFavorite.getYear()
                + "\n\tRating: " + existingFavorite.getRating() + "/10");
    }

    /**
     * Söker upp och låter användaren ersätta spelet och dess information med ny information
     */
    public static void EditGame () {
        System.out.print("What game do you want to Edit?: ");
        String oldName = scan.nextLine();
        Game existingGame = controllerGame.searchGame(oldName);
        if (existingGame == null) {
            System.out.println("Game doesn't exist");
        }
        System.out.print("\nGame name: ");
        String newName = scan.nextLine();
        System.out.print("\nGame ganre: ");
        String newGenre = scan.nextLine();
        System.out.print("\nGame release date: ");
        String newYear = scan.nextLine();
        System.out.print("\nRate the game (1 lowest and 10 max): ");
        int newRating = scan.nextInt();
        if (newRating >= 10) {
            newRating = 10;
        }
        if (newRating <= 0) {
            newRating = 1;
        }
        scan.nextLine();

        System.out.print("\nWhat is the name of the Developers?: ");
        String newDevname = scan.nextLine();
        System.out.print("\nWhat gaming platform is the game on?: ");
        String newPlatform = scan.nextLine();

        Game newGame = Game.createGame(newName, newGenre, newYear,
                Integer.toString(newRating), newDevname, newPlatform);
        if (controllerGame.EditGame(existingGame, newGame)) {
            System.out.println("New game added: \nNamn: " + newName
                    + ", \nGenre: " + newGenre + ", \nRelease date: " + newYear
                    + ", \nRating: " + newRating + "/10" + ", \nDeveloper name: "
                    + newDevname + ", \nGame platform: " + newPlatform);
        } else {
            System.out.println(newName + " already exist.");
        }
    }

    public static void EditMovie () {
        System.out.print("What movie do you want to Edit?: ");
        String oldName = scan.nextLine();
        Movie existingMovie = controllerMovie.searchMovie(oldName);
        if (existingMovie == null) {
            System.out.println("Movie doesn't exist");
        }
        System.out.print("\nMovie name: ");
        String newName = scan.nextLine();
        System.out.print("\nMovie ganre: ");
        String newGenre = scan.nextLine();
        System.out.print("\nMovie release date: ");
        String newYear = scan.nextLine();
        System.out.print("\nRate the movie (1 lowest and 10 max): ");
        int newRating = scan.nextInt();
        if (newRating >= 10) {
            newRating = 10;
        }
        if (newRating <= 0) {
            newRating = 1;
        }
        scan.nextLine();

        System.out.print("\nWhat is the airtime of the movie?: ");
        String newLength = scan.nextLine();

        Movie newMovie = Movie.createMovie(newName, newGenre, newYear,
                Integer.toString(newRating), newLength);
        if (controllerMovie.EditMovie(existingMovie, newMovie)) {
            System.out.println("New game added: \nNamn: " + newName
                    + ", \nGenre: " + newGenre + ", \nRelease date: " + newYear
                    + ", \nRating: " + newRating + "/10" + ", \nMovie length: "
                    + newLength);
        } else {
            System.out.println(newName + " already exist.");
        }
    }

    public static void EditMusic () {
        System.out.print("What music do you want to Edit?: ");
        String oldName = scan.nextLine();
        Music existingMusic = controllerMusic.searchMusic(oldName);
        if (existingMusic == null) {
            System.out.println("Music doesn't exist");
        }
        System.out.print("\nMusic name: ");
        String newName = scan.nextLine();
        System.out.print("\nMusic ganre: ");
        String newGenre = scan.nextLine();
        System.out.print("\nMusic release date: ");
        String newYear = scan.nextLine();
        System.out.print("\nRate the music (1 lowest and 10 max): ");
        int newRating = scan.nextInt();
        if (newRating >= 10) {
            newRating = 10;
        }
        if (newRating <= 0) {
            newRating = 1;
        }
        scan.nextLine();

        System.out.print("\nWhat album/ albums are there?: ");
        String newAlbum = scan.nextLine();
        System.out.print("\nHow many tracks are there?: ");
        String newTracks = scan.nextLine();

        Music newMusic = Music.createMusic(newName, newGenre, newYear,
                Integer.toString(newRating), newAlbum, newTracks);
        if (controllerMusic.EditMusic(existingMusic, newMusic)) {
            System.out.println("New music added: \nNamn: " + newName
                    + ", \nGenre: " + newGenre + ", \nRelease date: " + newYear
                    + ", \nRating: " + newRating + "/10" + ", \nAlbum/ albums: "
                    + newAlbum + ", \nTracks");
        } else {
            System.out.println(newName + " already exist.");
        }
    }

    /**
     * Låter användaren ändra i Favorit listan dock utan att listan det inlägget kommer ifrån blir ändrat
     */
    public static void EditFavorite () {
        System.out.print("Which favorite do you want to Edit?: ");
        String oldName = scan.nextLine();
        Favorite existingFavorite = controllerFavorite.searchFavorite(oldName);
        if (existingFavorite == null) {
            System.out.println("Favorite doesn't exist");
        }
// Switch sats för att välja om nya favoriten är Spel, Film eller Music
        String newType = existingFavorite.getType();
       /* System.out.println("1. GAME \n2. MOVIE \n3. MUSIC");
        int choices = scan.nextInt();
        scan.nextLine();
        switch (choices) {
            case 1:
                newType = "GAME";
                break;
            case 2:
                newType = "MOVIE";
                break;
            case 3:
                newType = "MUSIC";
                break;
        }*/
        System.out.print("\nName: ");
        String newName = scan.nextLine();
        System.out.print("\nGanre: ");
        String newGenre = scan.nextLine();
        System.out.print("\nRelease date: ");
        String newYear = scan.nextLine();
        System.out.print("\nRating (1 lowest and 10 max): ");
        int newRating = scan.nextInt();
        if (newRating >= 10) {
            newRating = 10;
        }
        if (newRating <= 0) {
            newRating = 1;
        }
        scan.nextLine();

      Favorite newFavorite = Favorite.createFavorite(newType, newName,
              newGenre, newYear, Integer.toString(newRating));
        if (controllerFavorite.EditFavorite(existingFavorite, newFavorite)) {
            System.out.println( newType + " has been edited: \nNamn: " + newName
                    + " \nGenre: " + newGenre + " \nRelease date: " + newYear
                    + " \nRating: " + newRating + "/10");
        } else {
            System.out.println(newName + " already exist.");
        }
    }

    /**
     * Söker upp ett spel och tar bort det från listan med all information till det
     */
   public static void RemoveGame() {
       System.out.print("What game do you want to remove?: ");
       String name = scan.nextLine();
       Game existingGame = controllerGame.searchGame(name);
       if (existingGame == null) {
           System.out.println("Game doesn't exist");
       }
       if (controllerGame.RemoveGame(existingGame)) { System.out.println(); }
       else { System.out.println("Couldn't remove the game"); }
       System.out.println(existingGame.getName() + " has been removed");
   }

   public static void RemoveMovie() {
       System.out.print("What movie do you want to remove?: ");
       String name = scan.nextLine();
       Movie existingMovie = controllerMovie.searchMovie(name);
       if (existingMovie == null) {
           System.out.println("Movie doesn't exist");
       }
       if (controllerMovie.RemoveGame(existingMovie)) { System.out.println(); }
       else { System.out.println("Couldn't remove the movie"); }
       System.out.println(existingMovie.getName() + " has been removed");
   }

    public static void RemoveMusic() {
        System.out.print("What singer/ band do you want to remove?: ");
        String name = scan.nextLine();
        Music existingMusic = controllerMusic.searchMusic(name);
        if (existingMusic == null) {
            System.out.println("Singer/ band doesn't exist");
        }
        if (controllerMusic.RemoveMusic(existingMusic)) { System.out.println(); }
        else { System.out.println("Couldn't remove the singer/ band"); }
        System.out.println(existingMusic.getName() + " has been removed");
    }

   public static void RemoveFavorite() {
       System.out.print("What favorite do you want to remove?: ");
       String name = scan.nextLine();
       Favorite existingFavorite = controllerFavorite.searchFavorite(name);
       if (existingFavorite == null) {
           System.out.println("Favorite doesn't exist");
       }
       if (controllerFavorite.RemoveFavorite(existingFavorite)) { System.out.println(); }
       else {
           System.out.println("Couldn't remove the favorite");
       }
       System.out.println(existingFavorite.getName() + " has been removed");
   }



}


