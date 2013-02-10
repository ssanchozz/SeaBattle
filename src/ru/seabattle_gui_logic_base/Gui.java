package ru.seabattle_gui_logic_base;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    public Gui () {
        JFrame gamePanel = new JFrame("Sea Battle");
        gamePanel.setSize(800,600);
        gamePanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenuItem exitMenu = new  JMenuItem("Exit");
        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JMenuItem aboutMenu = new  JMenuItem("About");
        JMenuItem restartMenu = new  JMenuItem("Restart");
        restartMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("This is restart");
            }
        });

        gamePanel.setVisible(true);
        menuBar.add(aboutMenu);
        menuBar.add(restartMenu);
        menuBar.add(exitMenu);
        gamePanel.setJMenuBar(menuBar);

        gamePanel.setLayout(null);
        gamePanel.setLocationRelativeTo(null);

       GraphicField computerField = new GraphicField();
       computerField.setLocation(10, 10);

       gamePanel.add(computerField);
    }

}


