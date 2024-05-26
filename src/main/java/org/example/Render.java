package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {
    private int width = 700,height = 700;
    private int margin = 20;
    private int widthIn = width - 2*margin,heightIn = height - 2*margin;

    private double multiplicationX,multiplicationY;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    private Graphics g = image.getGraphics();

    public BufferedImage getImage() {
        return image;
    }

    // set
    public void setAutoMultiplicationX(int bigDistance){
        multiplicationX = (double) widthIn/(double) bigDistance;
    }
    public void setAutoMultiplicationY(int maxSpeed){
        multiplicationY = (double) heightIn/(double) maxSpeed;
    }
    // get

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void process(Numbers numbers){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,width,height);

        g.setColor(Color.WHITE);
        for (Planet planet : numbers.getPlanets()) {
            int x = (int)((double)planet.getDistance() * multiplicationX) + margin;
            int y = (int)((double)planet.getSpeed() * multiplicationY) + margin;

            int rad = margin;
            g.fillOval(x - rad,y - rad,rad*2,rad*2);
        }
    }
}
