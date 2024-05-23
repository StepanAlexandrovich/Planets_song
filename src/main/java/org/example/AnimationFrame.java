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

        this.setBounds(0,0,210,230);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private int i = 0;
    public void update(Numbers numbers){
        render.process(numbers);

        ////////////////
        repaint();
    }
}
