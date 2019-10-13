package com.projekt;

import java.util.Scanner;

public class Favorite extends Entertainment{
    private static Scanner scan = new Scanner(System.in);
    private String type;

    public Favorite(String type, String name, String genre, String year, String rating) {
        super(name, genre, year, rating);
        this.type = type;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    /**
     * Printar ut menyn för Favorite.
     */
    public static void printFavoriteMenu() {
        System.out.println(">---------FAVORITE MENU---------<");
        System.out.println("0. Show favorites Menu");
        System.out.println("1. Show favorites");
        System.out.println("2. Find favorite");
        System.out.println("3. Edit favorite");
        System.out.println("4. Remove favorite");
        System.out.println("5. Sort favorites");
        System.out.println("6. Random pick");
        System.out.println("7. Back");
        System.out.println(">-------------------------------<");
    }

    /**
     * En metod som används för att skapa ett inlägg i favoriteList
     * @param type representerar String type i ArrayList
     * @param name representerar String name i ArrayList
     * @param genre representerar String genre i ArrayList
     * @param year representerar String year i ArrayList
     * @param rating representerar String rating i ArrayList
     * @return returnerar nya värden i listan.
     */
    public static Favorite createFavorite (String type, String name, String genre, String year, String rating) {
        return new Favorite(type, name, genre, year, rating); }
}
