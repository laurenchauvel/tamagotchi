package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import modele.Maison;
import modele.Robot;

class TestRobot {
	
	//initialisation des attributs
	Robot boulon = new Robot("Boulon");
	
	
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
	
	@Test
	void TestDecreaseStat() {
		boulon.decreaseStat();
	}
	

}