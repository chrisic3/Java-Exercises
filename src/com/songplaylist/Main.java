/*
    Create a program that implements a playlist for songs
    Create a Song class having Title and Duration for a song.
    The program will have an Album class containing a list of songs.
    The albums will be stored in an ArrayList
    Songs from different albums can be added to the playlist and will appear in the list in the order
    they are added.
    Once the songs have been added to the playlist, create a menu of options to:-
    Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
    List the songs in the playlist
    A song must exist in an album before it can be added to the playlist (so you can only play songs that
    you own).
    Hint:  To replay a song, consider what happened when we went back and forth from a city before we
    started tracking the direction we were going.
    As an optional extra, provide an option to remove the current song from the playlist
    (hint: listiterator.remove()
 */

package com.songplaylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24
        play(playList);

    }

    public static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> listIterator = playList.listIterator();
        int choice;
        boolean quit = false;
        boolean skipForward = true;

        if (playList.isEmpty()) {
            System.out.println("The playlist is empty.");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().getTitle());
            printMenu();
        }

        while (!quit) {
            System.out.println("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    if (skipForward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().getTitle());
                            skipForward = false;
                        } else {
                            System.out.println("At the beginning of the playlist.");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().getTitle());
                            skipForward = true;
                        } else {
                            System.out.println("No more songs.");
                        }
                    }
                    break;
                case 2:
                    if (!skipForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        skipForward = true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getTitle());
                    } else {
                        System.out.println("No more songs.");
                        skipForward = false;
                    }
                    break;
                case 3:
                    if (skipForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        skipForward = false;
                    }

                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("At the beginning of the playlist.");
                        skipForward = true;
                    }
                    break;
                case 5:
                    if (!playList.isEmpty()) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().getTitle());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().getTitle());
                        }
                    }
                    break;
                case 4:
                    quit = true;
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("0 - Print menu");
        System.out.println("1 - Replay current song");
        System.out.println("2 - Skip forward");
        System.out.println("3 - Skip backward");
        System.out.println("4 - Quit");
    }
}
