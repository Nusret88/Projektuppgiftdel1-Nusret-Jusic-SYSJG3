package com.projekt;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerGame {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Game> gamesList;
    private static ControllerGame controllerGame = new ControllerGame ();

    public ControllerGame() {
        this.gamesList = new ArrayList<Game>();
    }
    /**
     * En metod som består av en meny gjord med Switch och loopas så länge back är falsk.
     */
    public static void menuGames() {
        boolean back = false;
        Game.printMenuGames();
        while (!back) {
            int menuGames = scanner.nextInt();
            scanner.nextLine();
            switch (menuGames) {
                case 0:
                    Game.printMenuGames();
                    break;
                case 1:
                    controllerGame.printGames();
                    break;
                case 2:
                    ProjektDel1.addNewGame();
                    break;
                case 3:
                    ProjektDel1.addFavoriteGame();
                    break;
                case 4:
                    ProjektDel1.RemoveGame();
                    break;
                case 5:
                    ProjektDel1.searchGame();
                    break;
                case 6:
                    ProjektDel1.EditGame();
                    break;
                case 7:
                    ProjektDel1.MainMenu();
                    back = true;
                    break;
            }
        }
    }
    /**
     * Kollar efter ett spel med findGame metoden i gamesList och om det finns returnerar den false.
     * Om den inte finns så returnerar den true där en .add körs för gamesList och lägger till ett inlägg.
     * @param game Denna parametern representerar det som söks i listan.
     * @return Om getName finns i listan returneras false annars returneras true.
     */
    public boolean addNewGame (Game game) {
        if(findGame(game.getName()) >= 0) {
            System.out.println("Game already exists in the list.");
            return false; }
        gamesList.add(game);
        System.out.println("----------->ADDED<-----------");
        //System.out.println("\nGame has been added");
        return true; }
    /** Denna metod returnerar index av det som söks.
     * @param game Denna parametern representerar det som söks i listan.
     * @return skickar tillbaka indexen av favorite.
     */
private int findGame (Game game){ return this.gamesList.indexOf(game); }

    /** letar igenom hela listan med hjälp av en for loop för att se om det finns ett namn i
     * listan som är likadant som det inskrivna namnet för att returnera positionen av det.
     * @param gameName Denna parametern representerar det som kommer sökas efter i listan.
     * @return om det sökta namnet existerar returneras nummret inuti i som representerar positinen i listan.
     * Annars returneras -1 vilket inte existerar i listan eftersom arraylistor börjar från 0.
     */
    private int findGame (String gameName) {
        for (int i = 0; i < this.gamesList.size(); i++) {
            Game game = this.gamesList.get(i);
            if (game.getName().equals(gameName)) {
                return i;
            }
        }
        return -1;
}
    /**
     *Metoden använder findGame metoden för att se om det sökta namnet finns i listan
     * och om det finns returneras namnet med .getName().
     * @param game Denna parametern representerar det som söks i listan.
     * @return Om det som söks efter finns returneras namnet annars returneras null.
     */
    public String searchGame(Game game) {
        if(findGame(game) >=0) {
            return game.getName();
        }
        return null;
    }
    /**
     * Metoden använder sig av findGame metoden för att se om namned som söks existerar i listan och om det gör
     * så sparas nummret av positionen i en int variabel som sedan returneras med hjälp av get. Om inget hittas returneras null.
     * @param name Denna parametern representerar namnet som söks i listan.
     * @return returnerar positionen i listan av det inskrivna namnet om det inte hittas returneras null.
     */
    public Game searchGame(String name) {
        int position = findGame(name);
        if(position >=0) {
            return this.gamesList.get(position);
        }
        return null;
    }
    /**
     * En metod som använder sig av findGame metoden för att hitta positionen som ska ersättas med ny information.
     * @param oldGame Parametern representerar namnet på det som ska ersättas.
     * @param newGame Parametern representerar det nya inlägget som ersätter det gammla.
     * @return om inget spel hittas returneras false tillsammans med medelandet "Does not exist"
     * om det hittas används .set för att ersätta den gammla informationen med ny på samma position.
     */
    public boolean EditGame(Game oldGame, Game newGame) {
        int position = findGame(oldGame);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.gamesList.set(position, newGame);
                return true; }
    /**
     *  En metod som använder sig av findGame metoden för att kolla efter det användaren söker efter för att sedan
     *  ta bort den positionen i listan med .remove.
     * @param game Parametern representerar det som ska tas bort.
     * @return använder .remove för att ta bort den hittade positionen med all information som fanns där.
     */
    public boolean RemoveGame(Game game) {
        int position = findGame(game);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.gamesList.remove(position);
        return true;
    }
    /**
     * En simpel metod som använder en for loop för att printa ut all information för alla element som existerar i listan.
     */
public void printGames () {
    System.out.println("----------->GAMES<-----------");
    for (int i = 0; i < gamesList.size(); i++) {
        System.out.println((i+1) + ". " +
                this.gamesList.get(i).getName() + "\n\tGanre: " +
                this.gamesList.get(i).getGenre() + "\n\tRelease date: " +
                this.gamesList.get(i).getYear() + "\n\tRating: " +
                this.gamesList.get(i).getRating() + "/10\n\tDeveloper: " +
                this.gamesList.get(i).getDevName() + "\n\tPlatform: " +
                this.gamesList.get(i).getPlatform());
    }
    System.out.println("-------------<>--------------");
}
    /**
     * printar ut ett slumpmässigt val ur gamesList, om listan är tom får användaren svaret "The Game list is empty".
     */
public void RandomGame () {
    if (gamesList.isEmpty()) {
        System.out.println("The Game list is empty");
        System.out.println("-------------><--------------");
        System.out.println("0. Show main menu");
        System.out.println("-------------<>--------------");
    } else {
    int position = (int) (Math.random() * gamesList.size());
    System.out.println("----------->RANDOM<-----------");
    System.out.println(
            "Name: " +
                    this.gamesList.get(position).getName() + "\n\tGanre: " +
                    this.gamesList.get(position).getGenre() + "\n\tRelease date: " +
                    this.gamesList.get(position).getYear() + "\n\tRating: " +
                    this.gamesList.get(position).getRating() + "/10");
    System.out.println("----------->GAME<-----------");
        System.out.println("0. Show main menu");
        System.out.println("-------------<>--------------");}
    }

}
