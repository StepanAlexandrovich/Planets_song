package org.example;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Planet> planets = new ArrayList<>();
    private int step = -1;

    private int value;

    public void createPlanets(int bigDistance){
        List<Integer> dividers = dividers(bigDistance);
        for (Integer divider : dividers) {
            planets.add(new Planet(divider,0,bigDistance - 1));
        }
    }
    private List<Integer> dividers(int value){
        List<Integer> dividers = new ArrayList<>();

        for (int i = 1; i < value; i++) {
            if(value%i == 0){
                dividers.add(i);
            }
        }

        return dividers;
    }

    // get
    public int getValue() {
        return value;
    }
    public Planet getCurrentPlanet(){
        for (Planet planet : planets) {
            if(planet.getDistance() == 0){
                return planet;
            }
        }
        return null;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public int getMinSpeed(){ return planets.get(0).getSpeed(); }
    public int getMaxSpeed(){ return planets.get(planets.size()-1).getSpeed(); }

    public void process(){
        for (Planet planet : planets) {
            planet.process();
        }

        Planet currentPlanet = getCurrentPlanet();
        if(currentPlanet!=null){
            value = currentPlanet.getSpeed();
        }else {
            value = 0;
        }
    }
}
