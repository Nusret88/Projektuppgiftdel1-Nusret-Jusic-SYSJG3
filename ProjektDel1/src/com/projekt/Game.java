package com.projekt;



public class Game extends Entertainment {
    private String devName;
    private String platform;

    public Game(String name, String genre, String year, String rating, String devName, String platform) {
        super(name, genre, year, rating);
        this.devName = devName;
        this.platform = platform;
    }

    public String getDevName() { return devName; }
    public void setDevName(String devName) { this.devName = devName; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    /**
     * Printar ut menyn för Game.
     */
    public static void printMenuGames() {
        System.out.println("--------->GAMES MENU<---------");
        System.out.println("0. Show Games Menu");
        System.out.println("1. list");
        System.out.println("2. Add a Game");
        System.out.println("3. Add a game to Favorites");
        System.out.println("4. Remove a game");
        System.out.println("5. Find a game");
        System.out.println("6. Edit a game");
        System.out.println("7. Back");
        System.out.println("--------------<>--------------");
    }
    /**
     * En metod som används för att skapa ett inlägg i gamesList
     * @param name representerar String name i ArrayList
     * @param genre representerar String genre i ArrayList
     * @param year representerar String year i ArrayList
     * @param rating representerar String rating i ArrayList
     * @param devName representerar String devName i ArrayList
     * @param platform representerar String platform i ArrayList
     * @return returnerar nya värden i listan.
     */
    public static Game createGame (String name, String genre, String year, String rating, String devName, String platform) {
        return new Game(name, genre, year, rating, devName, platform);
    }


}
