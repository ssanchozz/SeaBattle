package ru.bogdanov_alexander.java_base.game_graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.bogdanov_alexander.java_base.game_logic.*;

public class SwingJFrame extends JFrame {

    public static final int X_BACK_PANE_INDENT = 10;
    public static final int Y_BACK_PANE_INDENT = 10;
    public static final int BETWEEN_FIELDS_SPACING = 30;

    public SwingJFrame(Field playerField, Field computerField) {
        super("My pane");
        this.setSize(2*SwingField.FIELD_WIDTH + 2*X_BACK_PANE_INDENT + BETWEEN_FIELDS_SPACING + 16,
                SwingField.FIELD_HEIGHT + 2*Y_BACK_PANE_INDENT + SwingField.FIELD_BOARDER*6);
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
        menuBar.add(aboutMenu);
        menuBar.add(restartMenu);
        menuBar.add(exitMenu);

        this.setJMenuBar(menuBar);

        this.setLayout(null);
        this.setLocationRelativeTo(null);

        SwingCell[][] arrayOfPlayerCells = new SwingCell[10][10];
        generateFieldOfCells(arrayOfPlayerCells, playerField,
                X_BACK_PANE_INDENT + SwingField.INDENT_OF_LABLE,
                Y_BACK_PANE_INDENT + SwingField.INDENT_OF_LABLE);

        SwingCell[][] arrayOfEnemyCells = new SwingCell[10][10];
        generateFieldOfCells(arrayOfEnemyCells, computerField,
                SwingField.FIELD_WIDTH + X_BACK_PANE_INDENT + BETWEEN_FIELDS_SPACING + SwingField.INDENT_OF_LABLE,
                Y_BACK_PANE_INDENT + SwingField.INDENT_OF_LABLE);

        SwingField friendField = new SwingField();
        friendField.setLocation(X_BACK_PANE_INDENT, Y_BACK_PANE_INDENT);
        this.add(friendField);

        SwingField enemyField = new SwingField();
        enemyField.setLocation(SwingField.FIELD_WIDTH + X_BACK_PANE_INDENT + BETWEEN_FIELDS_SPACING, Y_BACK_PANE_INDENT);
        this.add(enemyField);
        this.setVisible(true);
    }

    public void generateFieldOfCells(SwingCell[][] arrayOfSwingCells, Field field, int xIndent, int yIndent) {
        String whoseField;
        int xPosition = xIndent;
        for (int cellCountY = 0; cellCountY < Field.MAP_HEIGHT; cellCountY++) {
            for (int cellCountX = 0; cellCountX < Field.MAP_WIDTH; cellCountX++) {
                if (field.getWhoseField().equals("player"))
                    whoseField = "player";
                else
                    whoseField = "computer";
                if (field.getCellsOfField()[cellCountX][cellCountY].isBoatIsSet()) {
                    arrayOfSwingCells[cellCountX][cellCountY] = new SwingCell(true, whoseField);
                } else {
                    arrayOfSwingCells[cellCountX][cellCountY] = new SwingCell(false, whoseField);
                }
                arrayOfSwingCells[cellCountX][cellCountY].setLocation(xIndent, yIndent);
                this.add(arrayOfSwingCells[cellCountX][cellCountY]);
                xIndent += SwingCell.CELL_HEIGHT + SwingField.BETWEEN_CELL_SPACING;
            }
            xIndent = xPosition;
            yIndent += SwingCell.CELL_HEIGHT + SwingField.BETWEEN_CELL_SPACING;
        }
    }
}
