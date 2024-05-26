package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationFrame extends JFrame{
    private JLabel label;
    private Render render = new Render();

    public AnimationFrame() {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(render.getImage()));

        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        this.add(label);

        this.setBounds(0,0,render.getWidth() + 30,render.getHeight() + 30);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private int i = 0;
    public void update(Numbers numbers){
        render.process(numbers);

        ////////////////
        repaint();
    }

    public void setAutoMultiplicationX(int bigDistance){
        render.setAutoMultiplicationX(bigDistance);
    }
    public void setAutoMultiplicationY(int maxSpeed){
        render.setAutoMultiplicationY(maxSpeed);
    }
}
