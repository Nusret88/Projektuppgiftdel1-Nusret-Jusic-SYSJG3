package com.projekt;

public class Music extends Entertainment {
    private String album;
    private String tracks;

    public Music(String name, String genre, String year, String rating, String album, String tracks) {
        super(name, genre, year, rating);
        this.album = album;
        this.tracks = tracks;
    }

    public String getTracks() { return tracks; }
    public void setTracks(String tracks) { this.tracks = tracks; }

    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }

    public static void printMenuMusic() {
        System.out.println("--------->MUSIC MENU<---------");
        System.out.println("0. Show Music Menu");
        System.out.println("1. list");
        System.out.println("2. Add a Music");
        System.out.println("3. Add a music to Favorites");
        System.out.println("4. Remove a music");
        System.out.println("5. Find a music");
        System.out.println("6. Edit a music");
        System.out.println("7. Back");
        System.out.println("--------------<>--------------");
    }

    public static Music createMusic (String name, String genre, String year, String rating,String album, String tracks) {
        return new Music (name, genre, year, rating, album, tracks);
    }
}
