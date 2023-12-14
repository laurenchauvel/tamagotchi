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
		Oiseau kengo = new Oiseau("Kengo", l);
	@Test
	void TestConstructeur() {
		assertEquals("Kengo", kengo.getNom());
		assertEquals(l, kengo.getLieu());
	}
	@Test
	void TestVoler() {
		kengo.voler();
		System.out.println(kengo.getHygiene());
		assertEquals(90, kengo.getHygiene());
		assertEquals(100, kengo.getMoral());
		assertEquals(90, kengo.getEnergie());
	}
}
