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
	void TestVaChercher() {
		kengo.vaChercher();
		System.out.println(kengo.getHygiene());
		assertEquals(90, kengo.getHygiene());
		assertEquals(100, kengo.getMoral());
		assertEquals(90, kengo.getEnergie());
	}

}
