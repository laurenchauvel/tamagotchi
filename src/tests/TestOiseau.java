package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import org.junit.jupiter.api.Test;
import tamagotchi.*;
import tamagotchi.Lieu.Piece;

class TestOiseau {
	//intialisation des attributs
		File image;
		File son ;
		Lieu l = new Lieu(Piece.Chambre, image, son);
		Oiseau bibi = new Oiseau("Bibi", l);
	@Test
	void TestConstructeur() {
		assertEquals("Bibi", bibi.getNom());
		assertEquals(l, bibi.getLieu());
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
    void TestRegarderTV() {    

        bibi.regarderTV();
        
        if (E >= 10) {
        	assertEquals(100, bibi.getMoral());
            assertEquals(E - 5, bibi.getEnergie());
            assertEquals(N - 10, bibi.getNourriture());
            assertEquals(H - 10, bibi.getHygiene());
        } else {
            
        	assertEquals(M, bibi.getMoral());
            assertEquals(E, bibi.getEnergie());
            assertEquals(N, bibi.getNourriture());
            assertEquals(H, bibi.getHygiene());
        }
    }
   
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
    void TestJardinage() {
    
        bibi.jardinage();
        
        if (E >= 20 && N >= 30) {
            assertEquals(100, bibi.getMoral());
            assertEquals(E - 10, bibi.getEnergie());
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
