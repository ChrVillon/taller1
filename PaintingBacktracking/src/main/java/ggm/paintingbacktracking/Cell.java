/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ggm.paintingbacktracking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author ggmendez
 */
public class Cell extends JPanel implements MouseListener {

    public Cell up, down, left, right;
    private static final Color colors[] = {new Color(255, 0, 0), new Color(0, 255, 0), new Color(0, 0, 255)};
    private final int row;
    private final int column;
    private final Cell cells[][];
    private boolean neighboursSet = false;

    public Cell(int row, int column, Cell[][] cells) {
        this.cells = cells;
        this.row = row;
        this.column = column;
        this.setSize(new Dimension(20, 20));
        this.setBackground(colors[BacktrackingExample.getRandomNumberInRange(0, 2)]);
        this.addMouseListener(this);
        this.setNeighbours();
    }

    public void setNeighbours() {
        try {
            up = cells[row - 1][column];
        } catch (Exception e) {
            up = null;
        }
        try {
            down = cells[row + 1][column];
        } catch (Exception e) {
            down = null;
        }
        try {
            left = cells[row][column - 1];
        } catch (Exception e) {
            left = null;
        }
        try {
            right = cells[row][column + 1];
        } catch (Exception e) {
            right = null;
        }
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

        Color oldColor = this.getBackground();
        Color newColor = new Color(255, 255, 0);
        
        // use pilas aquí para implementar lo mostrado en clase

       this.paint(newColor);
       if (this.up != null) this.up.paint(newColor);
       if (this.down != null) this.down.paint(newColor);
       if (this.left != null) this.left.paint(newColor);
       if (this.right != null) this.right.paint(newColor);
        
    }

    private boolean isPainted(Color aColor) {
        return this.getBackground().equals(aColor);
    }

    private void paint(Color color) {
        this.setBackground(color);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    

}
