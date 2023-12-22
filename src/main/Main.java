package main;

import view.View;
import modele.Sauvegarde;
import controller.Controller;

public class Main {

	public static void main(String[] args) {
		Sauvegarde sauvegarde = new Sauvegarde();
		View view = new View();
		Controller controller = new Controller(view, sauvegarde);
		
        view.setSauvegarde(sauvegarde); //todo Linda
		view.setController(controller);
	}

}
