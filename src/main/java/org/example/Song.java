package org.example;

public class Song {
    private int bigDistance;
    private boolean activate;

    public Song(int bigDistance, boolean activate) {
        this.bigDistance = bigDistance;
        this.activate = activate;
    }

    // set
    public void activate(){ activate = true; }
    public void deActivate(){ activate = false; }

    // get
    public int getBigDistance() {
        return bigDistance;
    }

    public boolean isActivate() {
        return activate;
    }
}
