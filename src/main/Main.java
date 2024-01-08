package main;

import controller.Controller;
import controller.Sauvegarde;
import view.View;

public class Main {

	public static void main(String[] args) {
		
		View view = new View();
		Sauvegarde sauvegarde = new Sauvegarde();
		Controller controller = new Controller(view, sauvegarde);
	}

}
