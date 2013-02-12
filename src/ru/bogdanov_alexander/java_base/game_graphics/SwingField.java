package ru.bogdanov_alexander.java_base.game_graphics;

import javax.swing.*;
import java.awt.*;

public class SwingField extends JComponent {

    public static int BETWEEN_CELL_SPACING = 5;
    public static int FIELD_BOARDER = 10;
    public static int INDENT_OF_LABLE = 40;
    public static int FIELD_HEIGHT = SwingCell.CELL_HEIGHT*10 + BETWEEN_CELL_SPACING*9 + FIELD_BOARDER*2 + INDENT_OF_LABLE;
    public static int FIELD_WIDTH = SwingCell.CELL_WIDTH*10 + BETWEEN_CELL_SPACING*9 + FIELD_BOARDER*2 + INDENT_OF_LABLE;

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
        GradientPaint paint = new GradientPaint(0, 0, Color.white, FIELD_WIDTH, FIELD_HEIGHT, Color.lightGray, true);
        g.setPaint(paint);
        g.fillRoundRect(0, 0, FIELD_WIDTH, FIELD_HEIGHT, ARC_WIDTH, ARC_HEIGHT);
        g.setColor(Color.lightGray);
        g.drawRoundRect(0, 0, FIELD_WIDTH, FIELD_HEIGHT, ARC_WIDTH, ARC_HEIGHT);
    }
}
