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
		//Test qui doit renvoyer ressources insuffisantes car energie <
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
	void TestJouer() {
		//TODO
	}
	
	@Test
	void TestSeLaver() {
		kengo.setHygiene(20);
		kengo.seLaver();
		assertEquals(80, kengo.getHygiene());
		
		kengo.setHygiene(60);
		kengo.seLaver();
		assertEquals(100, kengo.getHygiene());
	}
	
	@Test
	void TestFaireSport() {
		//TODO
	}
	
	@Test
	void TestBrosserDents() {
		kengo.setHygiene(20);
		kengo.brosserDent();
		System.out.println("h : " +kengo.getHygiene());
		assertEquals(60, kengo.getHygiene());
		
		kengo.setHygiene(80);
		kengo.brosserDent();
		assertEquals(100, kengo.getHygiene());
	}
	
	@Test
	void TestJardinage() {
		//TODO
	}
	
	@Test
	void TestVaChercher() {
		kengo.vaChercher();
		assertEquals(90, kengo.getHygiene());
		assertEquals(100, kengo.getMoral());
		assertEquals(90, kengo.getEnergie());
	}

}
