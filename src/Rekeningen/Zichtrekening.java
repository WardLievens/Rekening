package Rekeningen;

public class Zichtrekening extends Rekening {
	
	/**
	 * @invar | kredietLimiet >= 0
	 * @invar | balans >= -kredietLimiet
	 */
	private int balans;
	private int kredietLimiet;
	
	public int getKredietLimiet() {return kredietLimiet;}
	
	@Override
	public int getBalans() {
		return balans;
	}
	/**
	 * @throws IllegalArgumentException | bedrag < 0
	 * @throws IllegalArgumentException | kredietLimiet < 0
	 * 
	 * @post | getKredietLimiet() == kredietLimiet
	 * @post | getBalans() == bedrag
	 * 
	 */
	public Zichtrekening(int bedrag, int kredietLimiet) {
		if (bedrag < 0) {
			throw new IllegalArgumentException("initieel bedrag kan niet negatief zijn");
		}
		if (kredietLimiet < 0) {
			throw new IllegalArgumentException("initieel kredietLimiet kan niet negatief zijn");
		}
		this.balans = bedrag;
		this.kredietLimiet = kredietLimiet;
				
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
	 * @throws IllegalArgumentException | bedrag < 0
	 * @post | getBalans() == old(getBalans()) - result
	 * @post | result == Math.min(bedrag, old(getBalans()) + getKredietLimiet())
	 */
	@Override
	public int terugtrekken(int bedrag) {
		if (bedrag < 0) {
			throw new IllegalArgumentException("te storten bedrag kan niet negatief zijn");
		}
		int nieuw_bedrag = Math.min(bedrag, balans + kredietLimiet);
		this.balans -= nieuw_bedrag;
		return nieuw_bedrag;
	}
	
	@Override
	public String toString() {
		return "Huidige Balans op zichtrekening bedraagd : " + balans + " Krediet-limiet ingesteld op : " + kredietLimiet + ".";
	}
	
	@Override
	public boolean equals(Rekening other) {
		return (this.getClass() == other.getClass()) &&
				(this.getBalans() == other.getBalans()) &&
				(this.getKredietLimiet() == ((Zichtrekening)other).getKredietLimiet());
	}
	
	

}
