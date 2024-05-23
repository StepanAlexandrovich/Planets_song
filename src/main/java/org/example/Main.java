package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        AnimationFrame frame = new AnimationFrame();
        Sound sound = new Sound();
        sound.setDuration(1000).setVolume(5);

        sound.open();

        while(frame.isVisible()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            numbers.process();
            sound.process( (int)(numbers.getValue() * 100) );
            frame.update(numbers);
        }

        sound.close();
        frame.dispose();

    }
}