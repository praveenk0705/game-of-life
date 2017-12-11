package fi.pku.game;

import java.util.Random;

public class Cell {
	Random random = new Random();
	int state;
	int previous;

	public Cell() {
	    this.state = random.nextInt(2);
	    this.previous = state;
	  }

	void savePrevious() {
		this.previous = state;
	}

	void newState(int s) {
		this.state = s;
	}

	

}
