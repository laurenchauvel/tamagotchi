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
		//Nourriture insuffisante
		kengo.setNourriture(5);
		kengo.regarderTV();
		assertEquals(5, kengo.getNourriture());
		
		kengo.setEnergie(20);
		kengo.setMoral(5);
		kengo.setNourriture(15);
		kengo.setHygiene(5);
		kengo.regarderTV();
		assertEquals(5, kengo.getNourriture());
		assertEquals(0, kengo.getHygiene());
		assertEquals(20, kengo.getMoral());
		assertEquals(25, kengo.getEnergie());
	}
	
	@Test
	void TestJouer() {
		//Pas assez d'energie
		kengo.setEnergie(20);
		kengo.jouer();
		assertEquals(20, kengo.getEnergie());
		
		//Trop faim
		kengo.setNourriture(20);
		kengo.jouer();
		assertEquals(20, kengo.getNourriture());
		
		kengo.setEnergie(40);
		kengo.setNourriture(80);
		kengo.setHygiene(10);
		kengo.setMoral(50);
		kengo.jouer();
		assertEquals(60, kengo.getNourriture());
		assertEquals(0, kengo.getHygiene());
		assertEquals(75, kengo.getMoral());
		assertEquals(10, kengo.getEnergie());
		
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
		//Pas assez d'energie
		kengo.setEnergie(20);
		kengo.faireSport();
		assertEquals(20, kengo.getEnergie());
		
		//Trop faim
		kengo.setNourriture(20);
		kengo.faireSport();
		assertEquals(20, kengo.getNourriture());
		
		kengo.setEnergie(40);
		kengo.setNourriture(80);
		kengo.setHygiene(10);
		kengo.setMoral(50);
		kengo.faireSport();
		assertEquals(60, kengo.getNourriture());
		assertEquals(0, kengo.getHygiene());
		assertEquals(70, kengo.getMoral());
		assertEquals(20, kengo.getEnergie());
	}
	
	@Test
	void TestBrosserDents() {
		kengo.setHygiene(20);
		kengo.brosserDent();
		assertEquals(60, kengo.getHygiene());
		
		kengo.setHygiene(80);
		kengo.brosserDent();
		assertEquals(100, kengo.getHygiene());
	}
	
	@Test
	void TestJardinage() {
		//Pas assez d'energie
		kengo.setEnergie(15);
		kengo.jardinage();
		assertEquals(15, kengo.getEnergie());
		
		//Trop faim
		kengo.setNourriture(20);
		kengo.jardinage();
		assertEquals(20, kengo.getNourriture());
		
		kengo.setEnergie(40);
		kengo.setNourriture(80);
		kengo.setHygiene(10);
		kengo.setMoral(50);
		kengo.jardinage();
		assertEquals(60, kengo.getNourriture());
		assertEquals(0, kengo.getHygiene());
		assertEquals(65, kengo.getMoral());
		assertEquals(25, kengo.getEnergie());
	}
	
	@Test
	void TestVaChercher() {
		kengo.vaChercher();
		assertEquals(90, kengo.getHygiene());
		assertEquals(100, kengo.getMoral());
		assertEquals(90, kengo.getEnergie());
	}

}
