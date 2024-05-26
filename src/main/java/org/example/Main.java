package org.example;


public class Main {
    public static void main(String[] args) {
        double multiplicationHz = 0.5;
        int bigDistance = 1260;

        //-------------------
        Delay delay = new Delay();

        Numbers numbers = new Numbers();
        AnimationFrame frame = new AnimationFrame();
        Sound sound = new Sound();

        //----------------
        numbers.createPlanets(bigDistance);

        frame.setAutoMultiplicationX(bigDistance);
        frame.setAutoMultiplicationY(numbers.getMaxSpeed());

        sound.setDuration(500).setVolume(5);

        sound.open();

        while(frame.isVisible()){
            delay.delay(1);

            numbers.process();
            sound.process( (int)(borderDown(numbers.getValue(),200) * multiplicationHz) );
            frame.update(numbers);
        }

        sound.close();
        frame.dispose();

    }

    public static int borderDown(int sound,int borderDown){
        while (sound < borderDown && sound!=0){
            sound*=2;
        }
        return sound;
    }
}