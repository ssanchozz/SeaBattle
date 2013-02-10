package ru.bogdanov_alexander.java_base.game_graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.bogdanov_alexander.java_base.game_logic.*;

public class SwingJFrame extends JFrame {
    public SwingJFrame(Field field) {
        super("My pane");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

        this.setVisible(true);

        menuBar.add(aboutMenu);
        menuBar.add(restartMenu);
        menuBar.add(exitMenu);

        this.setJMenuBar(menuBar);

        this.setLayout(null);
        this.setLocationRelativeTo(null);

        /*SwingField friendField = new SwingField();
        friendField.setLocation(10, 10);
        this.add(friendField);*/

        SwingCell[][] arrayOfSwingCells = new SwingCell[10][10];
        generateFieldOfCells(arrayOfSwingCells, field);
    }
    public void generateFieldOfCells(SwingCell[][] arrayOfSwingCells, Field field) {
        int xIndent = 10;
        int yIndent = 10;
        for (int cellCountY = 0; cellCountY < Field.MAP_HEIGHT; cellCountY++) {
            for (int cellCountX = 0; cellCountX < Field.MAP_WIDTH; cellCountX++) {
                if (field.getCellsOfField()[cellCountX][cellCountY].isBoatIsSet()) {
                    arrayOfSwingCells[cellCountX][cellCountY] = new SwingCell(true);
                } else {
                    arrayOfSwingCells[cellCountX][cellCountY] = new SwingCell(false);
                }
                arrayOfSwingCells[cellCountX][cellCountY].setLocation(xIndent, yIndent);
                this.add(arrayOfSwingCells[cellCountX][cellCountY]);
                xIndent += SwingCell.CELL_HEIGHT + 5;
            }
            xIndent = 10;
            yIndent += SwingCell.CELL_HEIGHT + 5;
        }
    }
}
