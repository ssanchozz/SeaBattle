package ru.seabattle_gui_logic_base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicCell extends JComponent implements MouseListener {
    public static final int SIZE_OF_PRINTED_CELL = 32;

    public static int WIDTH = 32;
    public static int HEIGHT = 32;


    private boolean isSelected = false;
    private GraphicField field;

    public GraphicCell(GraphicField field, int x, int y) {
        this.field = field;
        this.field.add(this);
        setSize(WIDTH, HEIGHT);

        setLocation(GraphicField.HEADER_ZONE + GraphicField.SPACE_BETWEEN * 2 +
                (WIDTH + GraphicField.SPACE_BETWEEN) * x,
                GraphicField.HEADER_ZONE + GraphicField.SPACE_BETWEEN * 2 +
                        (HEIGHT + GraphicField.SPACE_BETWEEN) * y);

        addMouseListener(this);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        int lw = getWidth() - 1;
        int lh = getHeight() - 1;
        int rw = GraphicField.SPACE_BETWEEN * 2;
        int rh = GraphicField.SPACE_BETWEEN * 2;

        Color color = Color.red;

        if(isSelected) {
            color = Color.green;
        }

        g2d.setPaint(new GradientPaint(lw, lh, Color.white, lw / 4, lh / 4, color, true));
        g2d.fillRoundRect(0, 0, lw, lh, rw, rh);
        g2d.setColor(color);
        g2d.drawRoundRect(0, 0, lw, lh, rw, rh);
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
        isSelected = true;
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        isSelected = false;
        repaint();
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }



}
