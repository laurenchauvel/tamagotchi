package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import controller.Controller;

@SuppressWarnings("serial")
public class CreateTamagotchiView extends JPanel {
	
	private String[] elements = {"Oiseau", "Robot", "Lion", "Chien"};
	private JLabel chooseName ; 
	private JTextField name ;
	private JComboBox<String> choixEspece ;
	private JButton retour ;
	private Image backgroundImage;
	private GradientButton submit;
	
	public CreateTamagotchiView(View frame) {
		try {
            backgroundImage = ImageIO.read(getClass().getResource("/media/maison.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur de chargement de l'image de fond : " + e.getMessage());
        }
		setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour le positionnement
		GridBagConstraints gbc = new GridBagConstraints();
        
		chooseName = new JLabel("Choisissez un nom : ");
		chooseName.setForeground(Color.WHITE);
		name = new JTextField(20);
		choixEspece = new JComboBox<>(elements);
		submit = new GradientButton("Créer ce Tamagotchi");
		submit.setForeground(Color.WHITE);
		retour = new JButton("Retour");	
		retour.setBackground(new Color(216, 20, 20));
		retour.setForeground(Color.WHITE);
		JPanel retourPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		retourPanel.setOpaque(false);
		retourPanel.add(retour);

		// Configurez les contraintes pour retourPanel
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.weightx = 1;
		gbc.weighty = 0;  // Peu de poids vertical pour rester en haut
		add(retourPanel, gbc);

		
        
		// Configurer les boutons pour avoir la même taille
		Dimension buttonSize = new Dimension(200, 50);
		Font labelFont = new Font("Arial", Font.BOLD, 20);
		
		// Appliquer la police au JLabel
		chooseName.setFont(labelFont);
		submit.setPreferredSize(buttonSize);
	
		//-----------------------------------------------------------------------------------------------
		// Configuration des contraintes pour les autres composants
		gbc.insets = new Insets(5, 0, 5, 0); // Espacement entre les composants
		gbc.anchor = GridBagConstraints.CENTER;
		
		// Ajouter chooseName
		gbc.gridx = 0;
		gbc.gridy = 1; // Position Y dans la grille
		add(chooseName, gbc);

		// Ajouter name
		gbc.gridy = 2; // Incrémenter la position Y pour chaque nouveau composant
		add(name, gbc);

		// Ajouter choixEspece
		gbc.gridy = 3;
		add(choixEspece, gbc);

		// Ajouter submit
		gbc.gridy = 4;
		add(submit, gbc);
		
        
        //----------------------------------------------------------------------------------------------
	
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(getName().equals("")) {
					JOptionPane.showMessageDialog(CreateTamagotchiView.this, "Veuillez donner un nom au Tamagotchi.");
				}else if(!Pattern.compile("^[a-zA-Z]+$").matcher(getName()).matches()) {	
					JOptionPane.showMessageDialog(CreateTamagotchiView.this, "Le nom du Tamagotchi ne doit contenir que des lettres.");
				
				}else if(frame.getController().getSauvegarde().compareNames(getName())) {
					JOptionPane.showMessageDialog(CreateTamagotchiView.this, "Il existe deja un Tamagotchi portant ce nom.");
				}else {
					frame.getController().demarrerPartie(null);;
					
					frame.showGameView();
				}
			}
			
		});
		retour.addActionListener(e -> frame.showMenu());
		
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
	
	public String getEspece() {
		return (String) choixEspece.getSelectedItem();
	}
	
	public String getName() {
		return name.getText();
	}

}