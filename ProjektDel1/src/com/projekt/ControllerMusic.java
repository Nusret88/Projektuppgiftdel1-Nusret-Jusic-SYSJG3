package com.projekt;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerMusic {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Music> musicList;
    private static ControllerMusic controllerMusic = new ControllerMusic ();

   public ControllerMusic() { this.musicList = new ArrayList<Music>(); }
    /**
     * En metod som består av en meny gjord med Switch och loopas så länge back3 är falsk.
     */
    public static void menueMusic () {
        Music.printMenuMusic();
        boolean back3 = false;

        while (!back3) {
            int choices = scanner.nextInt();
            scanner.nextLine();
            switch (choices) {
                case 0:
                    Music.printMenuMusic();
                    break;
                case 1:
                    controllerMusic.printMusic();
                    break;
                case 2:
                    ProjektDel1.addNewMusic();
                    break;
                case 3:
                    ProjektDel1.addFavoriteMusic();
                    break;
                case 4:
                    ProjektDel1.RemoveMusic();
                    break;
                case 5:
                    ProjektDel1.searchMusic();
                    break;
                case 6:
                    ProjektDel1.EditMusic();
                    break;
                case 7:
                    ProjektDel1.MainMenu();
                    back3 = true;
                    break;

            }
        }
    }
    /**
     * Kollar efter ett favorite med findMusic metoden i musicList och om det finns returnerar den false.
     * Om den inte finns så returnerar den true där en .add körs för musicList och lägger till ett inlägg.
     * @param music Denna parametern representerar det som söks i listan.
     * @return Om getName finns i listan returneras false annars returneras true.
     */
public boolean addNewMusic (Music music) {
       if (FindMusic(music.getName()) >= 0) {
           System.out.println("Music already exists in the list.");
           return false;
       }
       this.musicList.add(music);
    System.out.println("\nMusic has been added");
       return true;
}
    /** Denna metod returnerar index av det som söks.
     * @param music Denna parametern representerar det som söks i listan.
     * @return skickar tillbaka indexen av favorite.
     */
private int FindMusic (Music music) { return this.musicList.indexOf(music); }
    /** letar igenom hela listan med hjälp av en for loop för att se om det finns ett namn i
     * listan som är likadant som det inskrivna namnet för att returnera positionen av det.
     * @param musicName Denna parametern representerar det som kommer sökas efter i listan.
     * @return om det sökta namnet existerar returneras nummret inuti i som representerar positinen i listan.
     * Annars returneras -1 vilket inte existerar i listan eftersom arraylistor börjar från 0.
     */
private int FindMusic (String musicName) {
    for (int i = 0; i < this.musicList.size(); i++) {
        Music music = this.musicList.get(i);
        if (music.getName().equals(musicName)) {
            return i;
        }
    }
    return -1;
}
    /**
     *Metoden använder findMovie metoden för att se om det sökta namnet finns i listan
     * och om det finns returneras namnet med .getName().
     * @param music Denna parametern representerar det som söks i listan.
     * @return Om det som söks efter finns returneras namnet annars returneras null.
     */
    public String searchMusic (Music music) {
        int position = FindMusic(music);
        if (FindMusic(music) >= 0) {
            return music.getName();
        }
        return null;
    }
    /**
     * Metoden använder sig av findMusic metoden för att se om namned som söks existerar i listan och om det gör
     * så sparas nummret av positionen i en int variabel som sedan returneras med hjälp av get. Om inget hittas returneras null.
     * @param name Denna parametern representerar namnet som söks i listan.
     * @return returnerar positionen i listan av det inskrivna namnet om det inte hittas returneras null.
     */
    public Music searchMusic (String name) {
        int position = FindMusic(name);
        if (position >= 0) {
            return this.musicList.get(position);
        }
        return null;
    }
    /**
     * En metod som använder sig av findMusic metoden för att hitta positionen som ska ersättas med ny information.
     * @param oldMusic Parametern representerar namnet på det som ska ersättas.
     * @param newMusic Parametern representerar det nya inlägget som ersätter det gammla.
     * @return om ingen songare eller band hittas returneras false tillsammans med medelandet "Does not exist"
     * om det hittas används .set för att ersätta den gammla informationen med ny på samma position.
     */
    public boolean EditMusic(Music oldMusic, Music newMusic) {
        int position = FindMusic(oldMusic);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.musicList.set(position, newMusic);
        return true; }
    /**
     *  En metod som använder sig av findMusic metoden för att kolla efter det användaren söker efter för att sedan
     *  ta bort den positionen i listan med .remove.
     * @param music Parametern representerar det som ska tas bort.
     * @return använder .remove för att ta bort den hittade positionen med all information som fanns där.
     */
    public boolean RemoveMusic(Music music) {
        int position = FindMusic(music);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.musicList.remove(position);
        return true;
    }
    /**
     * En simpel metod som använder en for loop för att printa ut all information för alla element som existerar i listan.
     */
    public void printMusic () {
        System.out.println("----------->MUSIC<-----------");
        for (int i = 0; i < musicList.size(); i++) {
            System.out.println((i+1) + ". " +
                    this.musicList.get(i).getName() + "\n\tGanre: " +
                    this.musicList.get(i).getGenre() + "\n\tRelease date: " +
                    this.musicList.get(i).getYear() + "\n\tRating: " +
                    this.musicList.get(i).getRating() + "/10\n\tAlbum: " +
                    this.musicList.get(i).getAlbum() + "\n\tTracks: " +
                    this.musicList.get(i).getTracks());
        }
        System.out.println("-------------<>--------------");
    }
    /**
     * printar ut ett slumpmässigt val ur musicList, om listan är tom får användaren svaret "The Music list is empty".
     */
    public void RandomMusic () {
        if (musicList.isEmpty()) {
            System.out.println("The Music list is empty");
            System.out.println("-------------><--------------");
            System.out.println("0. Show main menu");
            System.out.println("-------------<>--------------");
        } else {
        int position = (int) (Math.random() * musicList.size());
        System.out.println("----------->RANDOM<-----------");
        System.out.println(
                "Name: " +
                        this.musicList.get(position).getName() + "\n\tGanre: " +
                        this.musicList.get(position).getGenre() + "\n\tRelease date: " +
                        this.musicList.get(position).getYear() + "\n\tRating: " +
                        this.musicList.get(position).getRating() + "/10");
        System.out.println("----------->MUSIC<-----------");
            System.out.println("0. Show main menu");
            System.out.println("-------------<>--------------");} }

}
