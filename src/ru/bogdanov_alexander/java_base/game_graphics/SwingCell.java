package ru.bogdanov_alexander.java_base.game_graphics;

import javax.swing.*;
    import java.awt.*;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;

public class SwingCell extends JComponent implements MouseListener {
 //   public static final int SIZE_OF_PRINTED_CELL = 32;
    public static int CELL_WIDTH = 32;
    public static int CELL_HEIGHT = 32;
    public static final int CELL_ARC_WIDTH = 5;
    public static final int CELL_ARC_HEIGHT = 5;

    private boolean isSelected = false;

    public SwingCell(boolean selected) {
        isSelected = selected;
        setSize(CELL_WIDTH, CELL_HEIGHT);
    }

    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        paintGradientCell(g2d);
        super.paint(g);
    }

    public void paintGradientCell (Graphics2D g) {
        GradientPaint paint = new GradientPaint(0, 0, Color.WHITE, CELL_WIDTH, CELL_HEIGHT, Color.CYAN, true);
        g.setPaint(paint);
        g.fillRoundRect(0, 0, CELL_WIDTH, CELL_HEIGHT, CELL_ARC_WIDTH, CELL_ARC_HEIGHT);
        g.setColor(Color.lightGray);
        g.drawRoundRect(0, 0, CELL_WIDTH, CELL_HEIGHT, CELL_ARC_WIDTH, CELL_ARC_HEIGHT);
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

    public void mouseReleased(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){

    }


}
