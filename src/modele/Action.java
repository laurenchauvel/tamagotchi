package modele;

public enum Action {
	Dormir_EnVeille(""),
	Manger_SeRecharger(""),
	Jouer("Jouer"),
	RegarderTV("Regarder TV"),
	Jardiner("Jardiner"),
	Toilettes("Faire ses besoins"),
	SeLaver("Se laver"),
	BrosserDents("Se brosser les dents"),
	Sport("Faire du sport"),
	ActionSpeciale("");
	
	private String actionName;
	
	private Action (String name) {
		actionName = name;
	}
	
	public String getActionName() {
		return actionName ;
	}
	
	public void setActionName(String nom) {
		actionName = nom ;
	}
	
}
