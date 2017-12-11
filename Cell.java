package fi.pku.game;

import java.util.Random;

public class Cell {
	Random random = new Random();
	static int counter = 1;
	int state;
	int previous;

	public Cell() {
	    this.state = random.nextInt(2);
		//this.state = counter;
		//counter++;
	    this.previous = state;
	  }

	void savePrevious() {
		this.previous = state;
	}

	void newState(int s) {
		this.state = s;
	}

	

}
