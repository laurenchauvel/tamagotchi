package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

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
		chooseName = new JLabel("Choose a name : ");
		chooseName.setForeground(Color.WHITE);
		name = new JTextField(20);
		choixEspece = new JComboBox<>(elements);
		submit = new GradientButton("Créer Tamagotchi");
		submit.setForeground(Color.WHITE);
		retour = new JButton("Retour");	
		retour.setBackground(new Color(216, 20, 20));
		retour.setForeground(Color.WHITE);
        
        
		
		this.add(chooseName);
		this.add(name);
		this.add(choixEspece);
		this.add(submit);
		this.add(retour);
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO : A modfier
				
				if(!getName().equals("")) {
					frame.getController().createTamagotchi();
					
					frame.setGameView(new InterfaceJeuView(frame));
					//frame.getGameView().setController(frame.getController());
					frame.add(frame.getGameView(), frame.getGame());					
					
					frame.getLayout().show(frame.getPanel(), frame.getGame());
				}else {
					JOptionPane.showMessageDialog(CreateTamagotchiView.this, "Veuillez donner un nom au Tamagotchi");
				}
			}
			
		});
		retour.addActionListener(e -> frame.getLayout().show(frame.getPanel(), frame.getMenu()));
		
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
