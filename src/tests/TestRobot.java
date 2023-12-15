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
		//System.out.println(boulon.getNom());
		assertEquals(l , boulon.getLieu());
		//System.out.println(boulon.getLieu());
	}
	
	@Test
	void TestSeRecharger() {
		boulon.setEnergie(20);
		boulon.setBatterie(130);
		boulon.seRecharger();
		assertEquals(30,boulon.getEnergie());
		assertEquals(100,boulon.getBatterie());
		System.out.println(boulon.getEnergie());
		System.out.println(boulon.getBatterie());
	}
	
	@Test
	void TestEnVeille() {
		boulon.enVeille();
		System.out.println(boulon.getEnergie());
		assertEquals(100,boulon.getEnergie());
	}

}
