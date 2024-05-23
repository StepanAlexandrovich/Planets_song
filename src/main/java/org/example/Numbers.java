package org.example;

public class Numbers {
    private int step = -1;

    private int value;

    public int getValue() {
        return value;
    }

    public void process(){
        if(++step == 3){ step = 0; }

        if(step == 0){
            value = 1;
        }else
        if(step == 1){
            value = 2;
        }else
        if(step == 2){
            value = 3;
        }

    }
}
