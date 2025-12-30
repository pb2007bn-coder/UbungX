package h1;

public class Grid {
  private  Cell[][] gridArray;
  
  public Grid(Cell[] cells, int gridRows, int gridCols){
    gridArray = new Cell[gridRows][gridCols];
    int index = 0;
    
    for (int row = 0; row < gridRows; row++) {
      for (int col = 0; col < gridCols; col++) {
        gridArray[row][col] = new Cell(row, col);
      }
    }
    
    for (Cell c : cells) {
      int rRow = c.getIndexRow();
      int cCol = c.getIndexCol();
      
      if (rRow >= 0 && rRow < gridRows && cCol >= 0 && cCol < gridCols) {
        gridArray[rRow][cCol].setAlive(true);
      }
    }
    
    for (int row = 0; row < gridRows; row++) {
      for (int col = 0; col < gridCols; col++) {
        gridArray[row][col].countLivingNeighbors(this.getGridValues());
      }
    }
  }
  
  public int[][] getGridValues() {
	    int[][] values = new int[gridArray.length][gridArray[0].length];
	    
	    for (int row = 0; row < gridArray.length; row++) {
	      for (int col = 0; col < gridArray[0].length; col++) {
	        if (gridArray[row][col].isAlive() ) {
	          values[row][col] = 1;
	        } else {
	          values[row][col] = 0;
	        } // end of if-else
	      }
	    }
	    
	    return values;
	  }
  
  
  
  public void computeNextGen() {
    
    for (int row = 0; row < gridArray.length; row++) {
      for (int col = 0; col < gridArray[0].length; col++) {
        gridArray[row][col].countLivingNeighbors(this.getGridValues()); 
        
      }
    }
    
    
    for (int row = 0; row < gridArray.length; row++) {
      for (int col = 0; col < gridArray[0].length; col++) {
        Cell zelle = gridArray[row][col];
        zelle.setAlive(zelle.getIsAliveNextGen());
      }
    }
  }
  
  public void computeNextGen(int n){
    
    for (int count = 1; count <= n; count++) {
      computeNextGen();
    }
    
    
  }
  
}
  