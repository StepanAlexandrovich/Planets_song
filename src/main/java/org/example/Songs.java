package org.example;

import java.util.ArrayList;

public class Songs {
    private ArrayList<Song> songs = new ArrayList<>();

    public void addSong(Song song){
        songs.add(song);
    }
    private int currentIndex = -1;
    public Song nextSong(){
        if(songs.size()>0){
            for (int i = 0; i < songs.size(); i++) {
                if(++currentIndex > songs.size() - 1){ currentIndex = 0; }

                Song song = songs.get(currentIndex);
                if(song.isActivate()){ return song; }
            }
        }

        return new Song(0,false);
    }

    public Song getFirstSong() {
        if(songs.size()>0) { return songs.get(0);}
        else               { return new Song(0,true); }
    }
}
