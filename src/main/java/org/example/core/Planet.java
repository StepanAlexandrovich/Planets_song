package org.example.core;

public class Planet {
    private final int speed,start,end;
    // dynamic
    private int distance;

    public Planet(int speed, int start, int end) {
        this.speed = speed;
        this.start = start;
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public int getSpeed() {
        return speed;
    }

    public void process(){
        for (int i = 0; i < speed; i++) {
            if(++distance>end){
                distance = start;
            }
        }
    }
}
