package tests;

import static org.junit.jupiter.api.Assertions.*;


import java.io.File;

import org.junit.jupiter.api.Test;
import tamagotchi.Lieu.Piece;
import tamagotchi.*;

class TestRobot {
	
	//initialisation des attributs
	File image;
	File son;
	Lieu l = new Lieu(Piece.Chambre,image,son);
	Robot boulon = new Robot("Boulon",l);
	
	@Test
	void TestConstructeur() {
		assertEquals("Boulon", boulon.getNom());
		assertEquals(l , boulon.getLieu());
	}
	
	@Test
	void TestSeRecharger() {
		boulon.setEnergie(20);
		boulon.setBatterie(130);
		boulon.seRecharger();
		assertEquals(30,boulon.getEnergie());
		assertEquals(100,boulon.getBatterie());
	}
	
	@Test
	void TestEnVeille() {
		boulon.setEnergie(30);
		boulon.enVeille();
		System.out.println(boulon.getEnergie());
		assertEquals(50,boulon.getEnergie());
	}
	
	@Test
	void TestMourirDeVieillesse() {
		boulon.setVie(23);
		boulon.mourirDeVieillesse();
		if(boulon.estMort()) {
			assertEquals(true,boulon.estMort());
		}
	}
	
	
	
	void TestMourirDeDepression() {
		boulon.setMoral(21);
		boulon.perteDeMoral();
		boulon.mourirDeDepression();
	}

}