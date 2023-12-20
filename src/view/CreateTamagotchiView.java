package view;

import javax.swing.*;

@SuppressWarnings("serial")
public class CreateTamagotchiView extends JPanel {
	
	private String[] elements = {"Oiseau", "Robot", "Lion", "Chien"};
	private JLabel chooseName ; 
	private JTextField name ;
	private JComboBox<String> choixEspece ;
	private JButton retour ;
	
	private JButton submit;
	
	public CreateTamagotchiView(View frame) {
		
		chooseName = new JLabel("Choose a name : ");
		name = new JTextField(20);
		choixEspece = new JComboBox<>(elements);
		submit = new JButton("Créer Tamagotchi");
		retour = new JButton("Retour");
		
		this.add(chooseName);
		this.add(name);
		this.add(choixEspece);
		this.add(submit);
		this.add(retour);
		
		submit.addActionListener(e -> System.out.println("Bouton 'Créer Tamagotchi' cliqué"));
		retour.addActionListener(e -> frame.getLayout().show(frame.getPanel(), frame.getMenu()));
		
	}
	
	
	public String getEspece() {
		return (String) choixEspece.getSelectedItem();
	}
	
	public String getName() {
		return name.getText();
	}

}
