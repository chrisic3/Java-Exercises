package com.songplaylist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) {
            return false;
        }

        songs.add(new Song(title, duration));
        return true;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if ((index < 0) || (index > songs.size())) {
            System.out.println("Track does not exist.");
            return false;
        }

        playList.add(songs.get(index));
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song == null) {
            System.out.println("Track does not exist.");
            return false;
        }

        playList.add(song);
        return true;
    }

    private Song findSong(String title) {
        for (Song checkedSong: songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }

        return null;
    }
}
