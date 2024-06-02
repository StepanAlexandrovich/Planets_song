package org.example;


import org.example.audibility.Sound;
import org.example.audibility.SoundScaling;
import org.example.core.Numbers;
import org.example.listener.MouseListenerImpl;
import org.example.visibility.AnimationFrame;

public class Main {
    Numbers numbers = new Numbers();
    SoundScaling scaling = new SoundScaling();
    MouseListenerImpl mouseListener = new MouseListenerImpl(this);
    AnimationFrame frame = new AnimationFrame();
    Sound sound = new Sound();

    enum Mode{ PROCESS,PAUSE,NEXT }
    private Mode mode = Mode.PROCESS;
    public static void main(String[] args) {
        new Main().start();
    }

    private void start(){
        Delay delay = new Delay();

        Songs songs = new Songs();
        songs.addSong(new Song(252,true));
        songs.addSong(new Song(360,true));
        songs.addSong(new Song(1260,true));

        Song song = songs.nextSong();



        updateSong(song);
        //----------------
        frame.addListener(mouseListener);
        sound.open();

        while(frame.isVisible()){


            switch (mode){
                case PROCESS:
                    numbers.process();
                    sound.process(scaling.newSound(numbers.getValue()));
                    frame.update(numbers);
                    break;
                case PAUSE:
                    delay.delay(5);
                    break;
                case NEXT:
                    updateSong(song = songs.nextSong());

                    mode = Mode.PROCESS;
                    break;
            }

        }

        sound.close();
        frame.dispose();
    }

    private void updateSong(Song song){
        int smoothness = 1;

        numbers.createPlanets(song.getBigDistance(),smoothness);

        frame.setAutoMultiplicationX(song.getBigDistance()*smoothness);
        frame.setAutoMultiplicationY(numbers.getMaxSpeed());

        sound.setDuration(500).setVolume(5);
    }

    // mode
    public void next() { mode = Mode.NEXT; }
    public void startStop() {
        if(mode == Mode.PROCESS){
            mode = Mode.PAUSE;
        }else
        if(mode == Mode.PAUSE){
            mode = Mode.PROCESS;
        }
    }
}