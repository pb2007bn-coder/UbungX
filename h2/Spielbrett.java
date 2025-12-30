package h2;

public class Spielbrett {
  
  private Feld [][]brett;
  private int dim;
  
  
  public Spielbrett(int dim){
    this.dim = dim;
    this.brett  = new Feld [dim][dim];
  }
  
  public Feld[][] getBrett() {
    return brett;
  }

    
  public void setBrett(Feld[][] brett) {
    this.brett = brett;
  }

    
  public int getDim() {
    return dim;
  }

    
  public void setDim(int dim) {
    this.dim = dim;
    
    this.brett = new Feld[dim][dim];
  }
  
  public Feld getFeld(int row, int col) {
	    return brett[row][col];
	}
  public void printBrett(Spielstein spielstein) {
	    for (int i = 0; i < dim; i++) {
	        for (int j = 0; j < dim; j++) {
	            Feld f = brett[i][j];
	            String feldDarstellung = "";

	            if (f.getBoese()) {
	                feldDarstellung += "X";
	            } else {
	                feldDarstellung += " ";
	            }

	            feldDarstellung += f.getDirection();

	            if (spielstein.getCurrentRow() == i && spielstein.getCurrentCol() == j) {
	                feldDarstellung = "[" + feldDarstellung + "]";
	            } else {
	                feldDarstellung = " " + feldDarstellung + " ";
	            }

	            System.out.print(feldDarstellung);
	        }
	        System.out.println();
	    }
	}


}
