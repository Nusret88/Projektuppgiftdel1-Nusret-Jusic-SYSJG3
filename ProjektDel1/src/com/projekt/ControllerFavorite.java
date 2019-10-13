package com.projekt;

import java.util.*;

public class ControllerFavorite {
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Favorite> favoriteList;
    private static ControllerFavorite controllerFavorite = new ControllerFavorite ();

    public ControllerFavorite() { this.favoriteList = new ArrayList<Favorite>(); }

    public static ArrayList<Favorite> getFavoriteList() {
        return favoriteList;
    }

    /**
     * En metod som består av en meny gjord med Switch och loopas så länge back4 är falsk.
     */
    public static void menuFavorite () {
        boolean back4 = false;
        Favorite.printFavoriteMenu();
        while (!back4){
                    int menuFavorites = scan.nextInt();
                    scan.nextLine();
                    switch (menuFavorites) {
                        case 0:
                            Favorite.printFavoriteMenu();
                            break;
                        case 1:
                            controllerFavorite.printFavorite();
                            break;
                        case 2:
                            ProjektDel1.searchFavorite();
                            break;
                        case 3:
                            ProjektDel1.EditFavorite();
                            break;
                        case 4:
                            ProjektDel1.RemoveFavorite();
                            break;
                        case 5:
                            controllerFavorite.sort();
                            back4 = true;
                            break;
                        case 6:
                            controllerFavorite.RandomFavorite();
                            break;
                        case 7:
                            back4 = true;
                            ProjektDel1.MainMenu();
                            break;
                    }
                }
            }

    /**
     * Kollar efter ett favorite med findFavorite metoden i favoriteList och om det finns returnerar den false.
     * Om den inte finns så returnerar den true där en .add körs för favoriteList och lägger till ett inlägg.
     * @param favorite Denna parametern representerar det som söks i listan.
     * @return Om getName finns i listan returneras false annars returneras true.
     */
    public boolean addNewFavorite (Favorite favorite) {
       if(findFavorite(favorite.getName()) >= 0) {
            System.out.println("The Favorite already exists in the list.");
            return false; }
        favoriteList.add(favorite);
        System.out.println("\nNew Favorite has been added:");
        return true; }

    /** Denna metod returnerar index av det som söks.
     * @param favorite Denna parametern representerar det som söks i listan.
     * @return skickar tillbaka indexen av favorite.
     */
    private int findFavorite (Favorite favorite){ return this.favoriteList.indexOf(favorite); }

    /** letar igenom hela listan med hjälp av en for loop för att se om det finns ett namn i
     * listan som är likadant som det inskrivna namnet för att returnera positionen av det.
     * @param favoriteName Denna parametern representerar det som kommer sökas efter i listan.
     * @return om det sökta namnet existerar returneras nummret inuti i som representerar positinen i listan.
     * Annars returneras -1 vilket inte existerar i listan eftersom arraylistor börjar från 0.
     */
    private int findFavorite (String favoriteName) {
        for (int i = 0; i < this.favoriteList.size(); i++) {
            Favorite favorite = this.favoriteList.get(i);
            if (favorite.getName().equals(favoriteName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *Metoden använder findFavorite metoden för att se om det sökta namnet finns i listan
     * och om det finns returneras namnet med .getName().
     * @param favorite Denna parametern representerar det som söks i listan.
     * @return Om det som söks efter finns returneras namnet annars returneras null.
     */
    public String searchFavorite(Favorite favorite) {
        if(findFavorite(favorite) >= 0) {
            return favorite.getName();
        }
        return null;
    }

    /**
     * Metoden använder sig av findFavorite metoden för att se om namned som söks existerar i listan och om det gör
     * så sparas nummret av positionen i en int variabel som sedan returneras med hjälp av get. Om inget hittas returneras null.
     * @param name Denna parametern representerar namnet som söks i listan.
     * @return returnerar positionen i listan av det inskrivna namnet om det inte hittas returneras null.
     */
    public Favorite searchFavorite(String name) {
        int position = findFavorite(name);
        if(position >=0) {
            return this.favoriteList.get(position);
        }
        return null;
    }
    /**
     * En metod som använder sig av findFavorite metoden för att hitta positionen som ska ersättas med ny information.
     * @param oldFavorite Parametern representerar namnet på det som ska ersättas.
     * @param newFavorite Parametern representerar det nya inlägget som ersätter det gammla.
     * @return om ingen favorit hittas returneras false tillsammans med medelandet "Does not exist"
     * om det hittas används .set för att ersätta den gammla informationen med ny på samma position.
     */
    public boolean EditFavorite(Favorite oldFavorite, Favorite newFavorite) {
        int position = findFavorite(oldFavorite);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        favoriteList.set(position, newFavorite);
        return true;
    }

    /**
     *  En metod som använder sig av findFavorite metoden för att kolla efter det användaren söker efter för att sedan
     *  ta bort den positionen i listan med .remove.
     * @param favorite Parametern representerar det som ska tas bort.
     * @return använder .remove för att ta bort den hittade positionen med all information som fanns där.
     */
    public boolean RemoveFavorite(Favorite favorite) {
        int position = findFavorite(favorite);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        favoriteList.remove(position);
        return true;
    }

    /**
     * En simpel metod som använder en for loop för att printa ut all information för alla element som existerar i listan.
     */
    public void printFavorite () {
        System.out.println("----------->FAVORITES<-----------");
        for (int i = 0; i < favoriteList.size(); i++) {
            System.out.println((i+1) + ". " +
                    this.favoriteList.get(i).getType() + "\n\tName: " +
                    this.favoriteList.get(i).getName() + "\n\tGanre: " +
                    this.favoriteList.get(i).getGenre() + "\n\tRelease date: " +
                    this.favoriteList.get(i).getYear() + "\n\tRating: " +
                    this.favoriteList.get(i).getRating() + "/10");
        }
        System.out.println("---------------<>----------------"); }

        // En simpel sortering dock sorterar den inte nummer över 1-9 så bra, för det behövs en egen compare metod
    /**
     * En metod som använder sig av .sort och Comperatorn som redan existerar i bibleoteket för att sortera listan efter namn i bokstavsordning.
     */
    public void SortName () {
    this.favoriteList.sort(Comparator.comparing(Favorite::getName));
    System.out.println("Favorites has been sorted by name");
}
    /**
     * En metod som använder sig av .sort och Comperatorn som redan existerar i bibleoteket för att sortera listan efter type i bokstavsordning.
     */
    public void SortType () {
        this.favoriteList.sort(Comparator.comparing(Favorite::getType));
        System.out.println("Favorites has been sorted by type");
    }
    /**
     * En metod som använder sig av .sort och Comperatorn som redan existerar i bibleoteket för att sortera listan efter genre i bokstavsordning.
     */
    public void SortGenre () {
        this.favoriteList.sort(Comparator.comparing(Favorite::getGenre));
        System.out.println("Favorites has been sorted by genre");
    }

    /**
     * en meny för att kalla på tre sorterings metoder.
     */
    public void sort() {
        System.out.println("1. Sort by type \n2. Sort by name \n3. Sort by genre \n4. Back");
        int choices = scan.nextInt();
        scan.nextLine();
        boolean back = false;
        while (!back) {
            switch (choices) {
                case 1:
                    controllerFavorite.SortType();
                    back = true;
                    ControllerFavorite.menuFavorite();
                    break;
                case 2:
                    controllerFavorite.SortName();
                    back = true;
                    ControllerFavorite.menuFavorite();
                    break;
                case 3:
                    controllerFavorite.SortGenre();
                    back = true;
                    ControllerFavorite.menuFavorite();
                    break;
                case 4:
                    back = true;
                    ControllerFavorite.menuFavorite();
                    break;
            }
        }
    }

    /**
     * printar ut ett slumpmässigt val ur favoriteList, om listan är tom får användaren svaret "The Favorite list is empty".
     */

    public void RandomFavorite () {
        if (favoriteList.isEmpty()) {
            System.out.println("The Favorite list is empty");
            System.out.println("-------------><--------------");
            System.out.println("0. Show favorite menu");
            System.out.println("-------------<>--------------");
        } else {
                int position = (int) (Math.random() * favoriteList.size());
        System.out.println("----------->RANDOM<-----------");
                System.out.println(
                        this.favoriteList.get(position).getType() + "\n\tName: " +
                                this.favoriteList.get(position).getName() + "\n\tGanre: " +
                                this.favoriteList.get(position).getGenre() + "\n\tRelease date: " +
                                this.favoriteList.get(position).getYear() + "\n\tRating: " +
                                this.favoriteList.get(position).getRating() + "/10");
        System.out.println("----------->"+ this.favoriteList.get(position).getType() +"<-----------");
            System.out.println("0. Show favorite menu");
            System.out.println("-------------<>--------------");}
        }


}
