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

    public boolean addNewGame (Game game) {
        if(findGame(game.getName()) >= 0) {
            System.out.println("Game already exists in the list.");
            return false; }
        gamesList.add(game);
        System.out.println("----------->ADDED<-----------");
        //System.out.println("\nGame has been added");
        return true; }

private int findGame (Game game){ return this.gamesList.indexOf(game); }
// stringen gameName blir game.getName
private int findGame (String gameName) {
        for (int i = 0; i < this.gamesList.size(); i++) {
            Game game = this.gamesList.get(i);
            if (game.getName().equals(gameName)) {
                return i;
            }
        }
        return -1;
}
// Om spelet finns i listan returnera det spelet annars gör inte
    public String searchGame(Game game) {
        if(findGame(game) >=0) {
            return game.getName();
        }
        return null;
    }
// Om namnet finns i listan returnera positionen av spelet
    public Game searchGame(String name) {
        int position = findGame(name);
        if(position >=0) {
            return this.gamesList.get(position);
        }
        return null;
    }

    public boolean EditGame(Game oldGame, Game newGame) {
        int position = findGame(oldGame);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.gamesList.set(position, newGame);
                return true; }

    public boolean RemoveGame(Game game) {
        int position = findGame(game);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.gamesList.remove(position);
        return true;
    }

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

public void RandomGame () {
    if (gamesList.isEmpty()) {
        System.out.println("The Game list is empty");
    } else {
    int position = (int) (Math.random() * gamesList.size());
    System.out.println("----------->RANDOM<-----------");
    System.out.println(
            "Name: " +
                    this.gamesList.get(position).getName() + "\n\tGanre: " +
                    this.gamesList.get(position).getGenre() + "\n\tRelease date: " +
                    this.gamesList.get(position).getYear() + "\n\tRating: " +
                    this.gamesList.get(position).getRating() + "/10");
    System.out.println("----------->GAME<-----------"); } }

}
