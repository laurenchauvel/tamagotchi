package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import tamagotchi.Chien;
import tamagotchi.Lieu;
import tamagotchi.Lieu.Piece;

class TestChien {
	
	//intialisation des attributs
	File image;
	File son ;
	Lieu l = new Lieu(Piece.Chambre, image, son);
	Chien kengo = new Chien("Kengo", l);
	
	
	@Test
	void TestConstructeur() {
		assertEquals("Kengo", kengo.getNom());
		assertEquals(l, kengo.getLieu());
	}
	
	@Test
	void TestDormir() {
		kengo.setEnergie(0);
		kengo.dormir();
		assertEquals(20, kengo.getEnergie());
		
		kengo.setEnergie(90);
		kengo.dormir();
		assertEquals(100, kengo.getEnergie());
		
	}
	
	@Test
	void TestRegarderTv() {
		kengo.setEnergie(5);
		kengo.regarderTV();
		assertEquals(5, kengo.getEnergie());
		
		kengo.setEnergie(20);
		kengo.setMoral(5);
		kengo.setNourriture(5);
		kengo.setHygiene(5);
		kengo.regarderTV();
		assertEquals(0, kengo.getNourriture());
		assertEquals(0, kengo.getHygiene());
		assertEquals(35, kengo.getMoral());
		assertEquals(15, kengo.getEnergie());
	}
	
	@Test
	void TestVaChercher() {
		kengo.vaChercher();
		assertEquals(90, kengo.getHygiene());
		assertEquals(100, kengo.getMoral());
		assertEquals(90, kengo.getEnergie());
	}

}
