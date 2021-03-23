package RekeningenTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Rekeningen.Spaarrekening;
import Rekeningen.Zichtrekening;

class RekeningTest {

	@Test
	void test() {
		Zichtrekening mijnZichtRekening = new Zichtrekening(0, 500);
		Spaarrekening mijnSpaarRekening = new Spaarrekening();
		mijnZichtRekening.stort(2000);
		assertEquals(mijnZichtRekening.getBalans(), 2000);
		mijnZichtRekening.stort(3000);
		assertEquals(mijnZichtRekening.getBalans(), 5000);
		assertEquals(mijnZichtRekening.terugtrekken(4000), 4000);
		assertEquals(mijnZichtRekening.getBalans(), 1000);
		assertEquals(mijnZichtRekening.terugtrekken(2000), 1500);
		assertEquals(mijnZichtRekening.getBalans(),-500);
		
		mijnSpaarRekening.stort(8000);
		assertEquals(mijnSpaarRekening.getBalans(), 8000);
		mijnSpaarRekening.stort(2000);
		assertEquals(mijnSpaarRekening.getBalans(), 10000);
		assertEquals(mijnSpaarRekening.terugtrekken(4000), 0);
		assertEquals(mijnSpaarRekening.getBalans(), 10000);
		assertEquals(mijnZichtRekening.toString(), 
				"Huidige Balans op zichtrekening bedraagd : -500 Krediet-limiet ingesteld op : 500.");
		assertEquals(mijnSpaarRekening.toString(), 
				"Huidige Balans op spaarrekening bedraagd : 10000.");
		
		Zichtrekening zr1 = new Zichtrekening(1000,250);
		Zichtrekening zr2 = new Zichtrekening(1000,250);
		Zichtrekening zr3 = new Zichtrekening(800,250);
		Zichtrekening zr4 = new Zichtrekening(1000,200);
		
		Spaarrekening sr1 = new Spaarrekening();
		Spaarrekening sr2 = new Spaarrekening();
		Spaarrekening sr3 = new Spaarrekening();
		sr1.stort(5000); sr2.stort(5000); sr3.stort(2000);
		
		assert zr1.equals(zr2);
		assert !zr1.equals(zr3);
		assert !zr1.equals(zr3);
		assert !zr1.equals(zr4);
		assert !zr1.equals(sr3);
		
		assert sr1.equals(sr2);
		assert !sr1.equals(sr3);
		assert !sr1.equals(zr2);
	}

}
