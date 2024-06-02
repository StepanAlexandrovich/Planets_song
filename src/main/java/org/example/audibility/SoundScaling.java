package org.example.audibility;

public class SoundScaling {
    private int borderDown = 110;
    private int borderUp = 220;

    public int newSound(double sound){
        if(sound!=0){
            while (sound<borderDown){
                sound*=2;
            }
            while (sound>borderUp){
                sound/=2;
            }
        }
        return (int)sound;
    }
}
