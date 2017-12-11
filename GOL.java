package fi.pku.game;

public class GOL {

	  int columns =4, rows = 4 ;

	  Cell[][] board;

	  public void GOL() {
	    board = new Cell[columns][rows];
	    init();
	  }
	  //initialize
	  public void init() {
	    for (int i = 0; i < columns; i++) {
	      for (int j = 0; j < rows; j++) {
	        board[i][j] = new Cell();
	      }
	    }
	  }
	  
	 public void displayInit() {
		  System.out.println("Initial Board");
			System.out.println("==============");
			for (int i = 0; i < columns; i++) {
				for (int j = 0; j < rows; j++) {
					System.out.print(board[i][j].state);
				}
				System.out.println("");
			}
	  }

	  public void generate() {
	     for ( int i = 0; i < columns;i++) {
	      for ( int j = 0; j < rows;j++) {
	        board[i][j].savePrevious();
	      }
	    }
	    

	    //Loop through and check neighbors
	     for (int x = 0; x < columns; x++) {
	      for (int y = 0; y < rows; y++) {
	    	  System.out.println("+++++++++");
	        int neighbors = 0;
	        for (int i = -1; i <= 1; i++) {
	          for (int j = -1; j <= 1; j++) {
	            neighbors += board[(x+i+columns)%columns][(y+j+rows)%rows].previous;
	            //System.out.println((x+i+columns)%columns);
	            
            //System.out.println((y+j+rows)%rows);
	           // System.out.println("========");
	          }
	        }

	        neighbors -= board[x][y].previous;

	        // Rules 
	        if      ((board[x][y].state == 1) && (neighbors <  2)) board[x][y].newState(0);          
	        else if ((board[x][y].state == 1) && (neighbors >  3)) board[x][y].newState(0);           
	        else if ((board[x][y].state == 0) && (neighbors == 3)) board[x][y].newState(1);           
	        
	      }
	    }
	  }

	 public void display() {
		  System.out.println("Updated Board");
			System.out.println("==============");
			for (int i = 0; i < columns; i++) {
				for (int j = 0; j < rows; j++) {
					System.out.print(board[i][j].state);
				}
				System.out.println("");
			}
	  }
	  //Driver function
	  public static void main(String[] args) {
		  GOL gol = new GOL();
			gol.GOL();
			gol.displayInit();
			gol.generate();
			System.out.println("==============");
			gol.display();
	}
	  

}
