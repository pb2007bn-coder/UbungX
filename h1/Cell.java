package h1;

public class Cell {
  private int indexRow;
  private int indexCol;
  private boolean alive;
  private int numLivingNeighbors;
  private boolean isAliveNextGen;
  
  public Cell (int indexRow, int indexCol, boolean alive){
    this.indexRow = indexRow;
    this.indexCol = indexCol;
    this.alive = false;
  }
  
  public Cell (int indexRow, int indexCol){
    this.indexRow = indexRow;
    this.indexCol = indexCol;
  }
  
  
  public int getIndexRow() {
    return indexRow;
  }

  public void setIndexRow(int indexRow) {
    this.indexRow = indexRow;
  }

  public int getIndexCol() {
    return indexCol;
  }

  public void setIndexCol(int indexCol) {
    this.indexCol = indexCol;
  }

  public boolean isAlive() {
    return alive;
  }

  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  public int getNumLivingNeighbors() {
    return numLivingNeighbors;
  }

  public void setNumLivingNeighbors(int numLivingNeighbors) {
    this.numLivingNeighbors = numLivingNeighbors;
  }

  public boolean getIsAliveNextGen() {
    return isAliveNextGen;
  }

  public void setAliveNextGen(boolean isAliveNextGen) {
    this.isAliveNextGen = isAliveNextGen;
  }

  public void countLivingNeighbors(Cell [][] gridArray){
    int zeile = this.getIndexRow();
    int spalte = this.getIndexCol();
    int count = 0;
    for (int z = -1; z <2; z++) {
      for (int s = -1; s < 2; s++) {
        
        if (z == 0 && s == 0) {
          continue;
        } // end of if
        
        int nachbarzeile = zeile + z;
        int nachbarspalte = spalte + s;
        
        if (nachbarzeile >= 0 && nachbarzeile < gridArray.length && nachbarspalte >= 0 && nachbarspalte < gridArray[0].length) {
          if (gridArray[nachbarzeile][nachbarspalte].isAlive()) {
            count++;
          } // end of if
        } // end of if
      }
    } // end of for
    
    this.setNumLivingNeighbors(count);
    
    decideNextStatus();
  }
    
  
  private void decideNextStatus(){
    if (alive == false) {
      if (numLivingNeighbors == 3) {
        isAliveNextGen = true;
      } else {
        isAliveNextGen = false;  
      } // end of if-else
    } // end of if
    else {
      if (numLivingNeighbors == 2 || numLivingNeighbors == 3) {
        isAliveNextGen = true;
      } else {
        isAliveNextGen = false;  
      } // end of if-else
    } // end of if-else
  }  
}
  
