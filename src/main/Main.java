package main;

import view.View;
import controller.Controller;
import controller.Sauvegarde;

public class Main {

	public static void main(String[] args) {
		
		View view = new View();
		Sauvegarde sauvegarde = new Sauvegarde();
		Controller controller = new Controller(view, sauvegarde);
	}

}
