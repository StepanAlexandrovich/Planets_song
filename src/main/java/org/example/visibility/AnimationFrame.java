package org.example.visibility;

import org.example.core.Numbers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class AnimationFrame extends JFrame{
    private JLabel label;
    private Render render = new Render();

    private List<JButton> buttons = new ArrayList<>();

    public AnimationFrame() {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(render.getImage()));

        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        this.add(label);

        buttons.add(newButton("PROCESS"));
        buttons.add(newButton("PAUSE"));
        buttons.add(newButton("NEXT"));
        for (JButton button : buttons) {
            this.add(button);
        }

        this.setBounds(0,0,render.getWidth() + 30,render.getHeight() + 150);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JButton newButton(String text){
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(100,50));
        button.setName(text);
        return button;
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

    public void addListener(MouseListener listener){
        for (JButton button : buttons) {
            button.addMouseListener(listener);
        }
    }
}
