/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;


public class Grid {
    private int[][] grid;
   public  Grid(int rows,int cols)
    {
        grid=new int[rows][cols];
        initialize();
    }
    public int getCellState(int row,int col) {
      if(row<0 || row>=grid.length)
          return -1;
      if(col<0 || col>=grid[0].length)
          return -1;
      else 
          return grid[row][col];
    }
    private void initialize()
    {
        
        for(int i=0;i<getGrid().length;i++)
        {
            for(int j=0;j<getGrid()[0].length;j++)
            {
                getGrid()[i][j]=(int) (0+(Math.random()*2));
              
            }
        
        }
        
    }
    public void display()
    {
      for(int i=0;i<getGrid().length;i++)
        {
            for(int j=0;j<getGrid()[0].length;j++)
            {
                System.out.print(getGrid()[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * @return the grid
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void setCellState(int row, int col, int state) {
       grid[row][col]=state; 
    }

    

    public void copyGrid(Grid tGrid) {
        int height = grid.length;
        int width = grid[0].length;
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
                grid[i][j] = tGrid.getCellState(i, j);
        }
    }

    
}
