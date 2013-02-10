package ru.bogdanov_alexander.java_base.game_graphics;

import javax.swing.*;
import java.awt.*;

public class SwingField extends JComponent {

    public static int BETWEEN_CELL_SPACING = 5;
    public static int CELL_ARRAY_BOARDER = 15;
    public static int FIELD_BOARDER = 10;
    public static int FIELD_HEIGHT = SwingCell.CELL_HEIGHT*10 + BETWEEN_CELL_SPACING*9 + CELL_ARRAY_BOARDER*2 + FIELD_BOARDER*2;
    public static int FIELD_WIDTH = SwingCell.CELL_WIDTH*10 + BETWEEN_CELL_SPACING*9 + CELL_ARRAY_BOARDER*2 + FIELD_BOARDER*2;

    public static int LEFT_FIELD_X_COORDINATE = 10;
    public static int LEFT_FIELD_Y_COORDINATE = 10;
    public static int ARC_WIDTH = 10;
    public static int ARC_HEIGHT = 10;

    public SwingField() {
        System.out.print("Lololo");
        setSize(FIELD_WIDTH, FIELD_HEIGHT);
    }

    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        paintGradientFieldSubstrate(g2d);
        super.paint(g);
    }

    public void paintGradientFieldSubstrate (Graphics2D g) {
        GradientPaint paint = new GradientPaint(0, 0, Color.white,
                                                LEFT_FIELD_X_COORDINATE + FIELD_WIDTH, LEFT_FIELD_Y_COORDINATE + FIELD_HEIGHT,
                                                Color.lightGray, true);
        g.setPaint(paint);
        g.fillRoundRect(0, 0, FIELD_WIDTH, FIELD_HEIGHT, ARC_WIDTH, ARC_HEIGHT);
        g.setColor(Color.lightGray);
        g.drawRoundRect(0, 0, FIELD_WIDTH, FIELD_HEIGHT, ARC_WIDTH, ARC_HEIGHT);
    }
}
