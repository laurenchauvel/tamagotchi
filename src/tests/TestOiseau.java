package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tamagotchi.Maison;
import tamagotchi.Oiseau;

class TestOiseau {
	//intialisation des attributs
		Oiseau bibi = new Oiseau("Bibi");
	@Test
	void TestConstructeur() {
		assertEquals("Bibi", bibi.getNom());
		assertEquals(Maison.Piece.Salon , bibi.getMaison().getPiece());
	}

	@Test
	void TestVoler() {
		bibi.voler();
		assertEquals(90, bibi.getHygiene());
		assertEquals(100, bibi.getMoral());
		assertEquals(90, bibi.getEnergie());
	}
	
	@Test
	void TestManger() {
        bibi.manger();
        assertEquals(100, bibi.getNourriture()); 
        assertEquals(100, bibi.getEnergie());    
    }
	
	@Test
	void TestSeLaver() {
        bibi.seLaver();
        assertEquals(100, bibi.getHygiene());   
    }

    

    @Test
    void TestBrosserDent() {
        bibi.brosserDent();
        assertEquals(100, bibi.getHygiene());   
    }
    
    @Test
    void TestDormir() {
    
        bibi.dormir();
        System.out.println("energie" + bibi.getEnergie());
        assertEquals(100, bibi.getEnergie());
    }
    
    int E = bibi.getEnergie();
    int M = bibi.getMoral();
    int N = bibi.getNourriture();
    int H = bibi.getHygiene();
   

    
   
    @Test
    void TestFaireSport() {
    	
    	bibi.faireSport();
        
        if (E >= 20 && N >= 20) {
           
            assertEquals(100, bibi.getMoral());
            assertEquals(E - 20, bibi.getEnergie());
            assertEquals(N - 20, bibi.getNourriture());
            assertEquals(H - 30, bibi.getHygiene());
        } else {
            
        	assertEquals(M, bibi.getMoral());
            assertEquals(E, bibi.getEnergie());
            assertEquals(N, bibi.getNourriture());
            assertEquals(H, bibi.getHygiene());
        }
    }
    
    

    @Test
    void TestJouer() {
      
        bibi.jouer();
        
        if (E >= 35 && N >= 30) {
            assertEquals(100, bibi.getMoral());
            assertEquals(E - 30, bibi.getEnergie());
            assertEquals(N - 20, bibi.getNourriture());
            assertEquals(H - 20, bibi.getHygiene());
            
        } else {
            
        	assertEquals(M, bibi.getMoral());
            assertEquals(E, bibi.getEnergie());
            assertEquals(N, bibi.getNourriture());
            assertEquals(H, bibi.getHygiene());
        }
    }
	
}
