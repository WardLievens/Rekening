package Rekeningen;

public abstract class Rekening {
	
	public abstract int getBalans();
	
	/**
	 * @pre | bedrag >= 0
	 * @post | getBalans() == old(getBalans()) + bedrag
	 */
	public abstract void stort(int bedrag);
	
	/**
	 * @pre | 0 <= bedrag
	 * @post | getBalans() >= old(getBalans()) - result
	 * @post | result >= 0
	 * @post | result <= bedrag
	 */
	public abstract int terugtrekken(int bedrag);
	
	/**
	 * geen flauw idee wat hier moet komen
	 */
	public abstract String toString();
	
	public abstract boolean equals(Rekening other);
	
}
