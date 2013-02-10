package ru.seabattle_gui_logic_base;

import javax.swing.*;
import java.awt.*;

public class GraphicField extends JComponent {
    public static int SECTOR_COUNT = 10;
    public static int SPACE_BETWEEN = 2;
    public static int HEADER_ZONE = 40;

    public static int HEIGHT = HEADER_ZONE + SPACE_BETWEEN * 2 + (GraphicCell.SIZE_OF_PRINTED_CELL + SPACE_BETWEEN) * (SECTOR_COUNT+1);
    public static int WIDTH = HEADER_ZONE + SPACE_BETWEEN * 2 + (GraphicCell.SIZE_OF_PRINTED_CELL + SPACE_BETWEEN) * (SECTOR_COUNT+1);

    public GraphicField() {

        // new GraphicCell(this, 0, 0);


        for(int i = 0; i < SECTOR_COUNT; i++)
            for(int j = 0; j < SECTOR_COUNT; j++)
                new GraphicCell(this, i,j);

        setSize(WIDTH, HEIGHT);
        printLettersAndNumbers();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        paintGradientBoxForFieldBottom(g2d);
        super.paint(g);
    }

    private void paintGradientBoxForFieldBottom(Graphics2D g) {
        int lw = getWidth() - 1;
        int lh = getHeight() - 1;
        int rw = SPACE_BETWEEN * 2;
        int rh = SPACE_BETWEEN * 2;

        GradientPaint paint = new GradientPaint(lw, lh, Color.white, lw / 4, lh / 4, Color.lightGray, true);
        g.setPaint(paint);
        g.fillRoundRect(0, 0, lw, lh, rw, rh);
        g.setColor(Color.lightGray);
        g.drawRoundRect(0, 0, lw, lh, rw, rh);
    }

    private void printLettersAndNumbers() {
        char[] letters = {'А', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'J', 'K'};
        for(int i = 0; i < SECTOR_COUNT; i++) {
            JLabel horizontal = new JLabel(String.valueOf(i + 1));
            if(i < letters.length)
                horizontal.setText(String.valueOf(letters[i]));
            JLabel vertical = new JLabel(String.valueOf(i + 1));
            horizontal.setHorizontalAlignment(JLabel.CENTER);
            horizontal.setVerticalAlignment(JLabel.CENTER);
            vertical.setHorizontalAlignment(JLabel.CENTER);
            vertical.setVerticalAlignment(JLabel.CENTER);
            horizontal.setSize(GraphicCell.SIZE_OF_PRINTED_CELL, HEADER_ZONE);
            vertical.setSize(HEADER_ZONE, GraphicCell.SIZE_OF_PRINTED_CELL);
            horizontal.setLocation(HEADER_ZONE + SPACE_BETWEEN * 2 +
                    (GraphicCell.SIZE_OF_PRINTED_CELL + SPACE_BETWEEN) * i, SPACE_BETWEEN);
            vertical.setLocation(SPACE_BETWEEN, HEADER_ZONE + SPACE_BETWEEN * 2 +
                    (GraphicCell.SIZE_OF_PRINTED_CELL + SPACE_BETWEEN) * i);
            add(horizontal);
            add(vertical);
        }
    }

}
