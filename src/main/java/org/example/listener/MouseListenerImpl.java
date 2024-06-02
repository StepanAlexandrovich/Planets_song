package org.example.listener;

import org.example.Main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerImpl implements MouseListener {
    private Main main;

    public MouseListenerImpl(Main main) {
        this.main = main;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();

        new Thread(()->{
            switch (button.getName()){
                case "NEXT": main.next(); break;
                case "PAUSE": main.startStop(); break;
            }
        }).start();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
