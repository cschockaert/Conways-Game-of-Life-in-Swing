/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.Transient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author mmylavar
 */
public class GameController extends JPanel{

    private Grid grid;
    private Grid tempGrid;
   

    public GameController(Grid pGrid) {
        grid=pGrid;
        tempGrid = new Grid(grid.getGrid().length, grid.getGrid()[0].length);
    }

    /**
     * @return the grid
     */
    public Grid getGrid() {
        return grid;
    }
public void playGrid(int generations)
{
    for(int i=1;i<=20;i++)
    {
       Grid tGrid= getNextGenForConsoleOutput();
       grid.copyGrid(tGrid);
       tGrid.display();
        System.out.println("");
    }
}
public Grid getNextGenForConsoleOutput() {
        int height = grid.getGrid().length;
        int width = grid.getGrid()[0].length;
        int state = -1, liveCount = -1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                liveCount = getLiveCells(i, j);
                state = 0;
                if (liveCount < 2 || liveCount > 3) {
                    state = 0;
                }
                else if((liveCount==2 || liveCount==3) && grid.getCellState(i, j)!=0)
                {
                    state=1;
                }
                else if(grid.getCellState(i, j)==0 && liveCount == 3)
                {
                    state=1;
                }
            
            tempGrid.setCellState(i, j, state);
            }
        }
     
        grid.copyGrid(tempGrid);
        return grid;
            
    }
    public void getNextGen() {
        int height = grid.getGrid().length;
        int width = grid.getGrid()[0].length;
        int state = -1, liveCount = -1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                liveCount = getLiveCells(i, j);
                state = 0;
                if (liveCount < 2 || liveCount > 3) {
                    state = 0;
                }
                else if((liveCount==2 || liveCount==3) && grid.getCellState(i, j)!=0)
                {
                    state=1;
                }
                else if(grid.getCellState(i, j)==0 && liveCount == 3)
                {
                    state=1;
                }
            
            tempGrid.setCellState(i, j, state);
            }
        }
     
        grid.copyGrid(tempGrid);
            
    }
    



    public int getLiveCells(int row, int col) {
        int liveCount = 0;
        if (grid.getCellState(row, col + 1) == 1) {
            liveCount++;
        }
        if (grid.getCellState(row, col - 1) == 1) {
            liveCount++;
        }
        if (grid.getCellState(row - 1, col) == 1) {
            liveCount++;
        }
        if (grid.getCellState(row + 1, col) == 1) {
            liveCount++;
        }
        if (grid.getCellState(row - 1, col - 1) == 1) {
            liveCount++;
        }
        if (grid.getCellState(row - 1, col + 1) == 1) {
            liveCount++;
        }
        if (grid.getCellState(row + 1, col - 1) == 1) {
            liveCount++;
        }
        if (grid.getCellState(row + 1, col + 1) == 1) {
            liveCount++;
        }
        return liveCount;
    }

    
    /**
     * @param grid the grid to set
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

     @Override
    @Transient
    public Dimension getPreferredSize() {
        return new Dimension(grid.getGrid().length * 4, grid.getGrid()[0].length * 4);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         Color gColor = g.getColor();

      
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                if (grid.getCellState(i, j) == 1) {
                    g.setColor(Color.yellow);
                   // g.drawRect(i, j+2, j, i+2);
                    g.fillRect(j * 10, i * 10, 10, 10);
                            }
                else
                {
                     g.setColor(Color.gray);
                   // g.drawRect(i, j+2, j, i+2);
                    g.fillRect(j * 10, i * 10, 10, 10);
                }
                
            }
        }

        g.setColor(gColor);
    }
}
