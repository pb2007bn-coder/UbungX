package h2;

public class Spielstein {
  
  private int currentRow;
  private int currentCol;
  private Spielbrett brett;
  
  public int getCurrentRow() {
    return currentRow;
  }

  public void setCurrentRow(int currentRow) {
    this.currentRow = currentRow;
  }

  public int getCurrentCol() {
    return currentCol;
  }

  public void setCurrentCol(int currentCol) {
    this.currentCol = currentCol;
  }

  public Spielbrett getBrett() {
    return brett;
  }

  public void setBrett(Spielbrett brett) {
    this.brett = brett;
  }
  
  public Spielstein(Spielbrett brett, int indexRow, int indexCol){
    this.brett = brett;
    this.currentRow = indexRow;
    this.currentCol = indexCol;  
  }
  
  private boolean movesOut(){
    Feld akt = brett.getFeld(currentRow, currentCol);
    switch (akt.getDirection()) {
      case 'U' : 
        if (currentRow == 0) {
          return true;
        } // end of if
        break;
      case 'D' : 
        if (currentRow == brett.getDim() -1 ) {
          return true;
        } // end of if
        break;
      case 'L' : 
        if (currentCol == 0) {
          return true;
        } // end of if
        break;
      case 'R' : 
        if (currentCol == brett.getDim() -1 ) {
          return true;
        } // end of if
        break;
      default:
        System.out.println("Fehler in der matrix"); 
      
    } // end of switch
    return false;
  }
  
  
  public void go (int n){
    while (n > 0 ) { 
      
      
      if (brett.getFeld(currentRow, currentCol).getBoese() != true) {
        switch (brett.getFeld(currentRow, currentCol).getDirection()) {
          case 'U' : 
            if (movesOut() == false) {
              currentRow--;
            } // end of if
            break;
          case 'D' : 
            if (movesOut() == false) {
              currentRow++;
            } // end of if
            break;
          case 'L' : 
            if (movesOut() == false) {
              currentCol--;
            } // end of if
            break;
          case 'R' : 
            if (movesOut() == false) {
              currentCol++;
            } // end of if
            break;
          default: 
          
        } // end of switch
      }else {
        
      } // end of if-else // end of if
      n--;
    }
  }
}
