package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {
    private BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
    private Graphics g = image.getGraphics();

    public BufferedImage getImage() {
        return image;
    }


    public void process(Numbers numbers){
        int multiplication = 10;
        g.setColor(Color.RED);
        g.fillRect(0,0,200,200);
        g.setColor(Color.BLACK);
        g.fillRect(numbers.getValue()*multiplication,0,multiplication,multiplication);
    }
}
