package tests;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;


import java.io.File;

import org.junit.jupiter.api.Test;

import modele.*;
import modele.Maison.Piece;

class TestRobot {
	
	//initialisation des attributs
	Robot boulon = new Robot("Boulon");
	
	/*
	@Test
	void TestConstructeur() {
		assertEquals("Boulon", boulon.getNom());
		assertEquals(Maison.Piece.Salon , boulon.getMaison().getPiece());
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
		assertEquals(50,boulon.getEnergie());
	}
	
	/*
	@Test
	void TestMourirDeVieillesse() {
		boulon.setVie(23);
		boulon.mourirDeVieillesse();
		if(boulon.estMort()) {
			assertEquals(true,boulon.estMort());
		}
	}

	
	
	@Test
	void TestMourirDeDepression() {
		boulon.setVie(17);
		boulon.setMoral(21);
		
		ExecutorService ex = Executors.newCachedThreadPool(); //faire un jeu de thread
		
		Runnable task1 = () -> {
			boulon.regarderTV();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable task2 = () -> {
			boulon.mourirDeDepression();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable task3 = () -> {
			boulon.jouer();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		ex.execute(task2);
		ex.execute(task1);
		ex.execute(task3);
		
		ex.shutdown();
		
		if(boulon.estMort()) {
			assertEquals(true,boulon.estMort());
		}
	}
	*/
	
	/*
	@Test
	void TestJouer() {
		boulon.setEnergie(31);
		boulon.setBatterie(21);
		boulon.setMoral(50);
		boulon.jouer();
		assertEquals(75, boulon.getMoral());
		assertEquals(1, boulon.getBatterie());
		assertEquals(1, boulon.getEnergie());
	}
	
	@Test
	void TestJardinage() {
		boulon.setEnergie(30);
		boulon.setBatterie(30);
		boulon.setMoral(50);
		boulon.jardinage();
		assertEquals(65, boulon.getMoral());
		assertEquals(10, boulon.getBatterie());
		assertEquals(20, boulon.getEnergie());
	}
	
	@Test
	void TestRegarderTV() {
		boulon.setEnergie(30);
		boulon.setBatterie(9);
		boulon.setMoral(50);
		boulon.regarderTV();
		assertEquals(50, boulon.getMoral());
		assertEquals(9, boulon.getBatterie());
		assertEquals(30, boulon.getEnergie());
	}
	
	@Test
	void TestSeDeplacer() {
		boulon.seDeplacer(Maison.Piece.Chambre);
		assertEquals(Maison.Piece.Chambre , boulon.getMaison().getPiece());
	}
	
	@Test
	void TestGetEspece() {
		System.out.println(boulon.getEspece());
		assertEquals("Robot", boulon.getEspece());
	}
	*/
	
	@Test
	void TestDecreaseStat() {
		boulon.decreaseStat();
	}
	

}