package com.projekt;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerMusic {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Music> musicList;
    private static ControllerMusic controllerMusic = new ControllerMusic ();

   public ControllerMusic() { this.musicList = new ArrayList<Music>(); }

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

public boolean addNewMusic (Music music) {
       if (FindMusic(music.getName()) >= 0) {
           System.out.println("Music already exists in the list.");
           return false;
       }
       this.musicList.add(music);
    System.out.println("\nMusic has been added");
       return true;
}

private int FindMusic (Music music) { return this.musicList.indexOf(music); }

private int FindMusic (String musicName) {
    for (int i = 0; i < this.musicList.size(); i++) {
        Music music = this.musicList.get(i);
        if (music.getName().equals(musicName)) {
            return i;
        }
    }
    return -1;
}

    public String searchMusic (Music music) {
        int position = FindMusic(music);
        if (FindMusic(music) >= 0) {
            return music.getName();
        }
        return null;
    }

    public Music searchMusic (String name) {
        int position = FindMusic(name);
        if (position >= 0) {
            return this.musicList.get(position);
        }
        return null;
    }

    public boolean EditMusic(Music oldMusic, Music newMusic) {
        int position = FindMusic(oldMusic);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.musicList.set(position, newMusic);
        return true; }

    public boolean RemoveMusic(Music music) {
        int position = FindMusic(music);
        if (position < 0) {
            System.out.println("Does not exist");
            return false;
        }
        this.musicList.remove(position);
        return true;
    }

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

    public void RandomMusic () {
        if (musicList.isEmpty()) {
            System.out.println("The Music list is empty");
        } else {
        int position = (int) (Math.random() * musicList.size());
        System.out.println("----------->RANDOM<-----------");
        System.out.println(
                "Name: " +
                        this.musicList.get(position).getName() + "\n\tGanre: " +
                        this.musicList.get(position).getGenre() + "\n\tRelease date: " +
                        this.musicList.get(position).getYear() + "\n\tRating: " +
                        this.musicList.get(position).getRating() + "/10");
        System.out.println("----------->MUSIC<-----------"); } }

}
