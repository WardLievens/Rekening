package Rekeningen;

public class Spaarrekening extends Rekening{
	
	/**
	 * @invar | 0 <= balans
	 */
	private int balans;
	
	@Override
	public int getBalans() {
		return balans;
	}
	
	/**
	 * @throws IllegalArgumentException | bedrag < 0
	 * @post | getBalans() == old(getBalans()) + bedrag
	 */
	@Override
	public void stort(int bedrag) {
		if (bedrag < 0) {
			throw new IllegalArgumentException("te storten bedrag kan niet negatief zijn");
		}
		this.balans += bedrag;
	}
	/**
	 * @post | result == 0
	 * @post | getBalans() == old(getBalans())
	 */
	@Override
	public int terugtrekken(int bedrag) {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Huidige Balans op spaarrekening bedraagd : " + balans + ".";
	}
	
	@Override
	public boolean equals(Rekening other) {
		return (this.getClass() == other.getClass()) &&
				(this.getBalans() == other.getBalans());
	}

}
