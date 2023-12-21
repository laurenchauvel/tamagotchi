package view;

import javax.swing.*;

import controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;

public class InterfaceJeuView extends JPanel {
	

    private Image backgroundImage;
    private JButton salon;
    private JButton salle_de_bain;
    private JButton chambre;
    private JButton cuisine;
    private JButton jardin;
    private JPanel boutonPanel;

    public InterfaceJeuView(View frame) {
    	
        // Configuration du layout du panneau principal
        setLayout(new BorderLayout());

        // Charger l'image d'arrière-plan
        changeBackgroundImage("/media/salon.png");

        // Initialisation des boutons
        salon = new JButton("Salon");
        salle_de_bain = new JButton("Salle de bain");
        chambre = new JButton("Chambre");
        cuisine = new JButton("Cuisine");
        jardin = new JButton("Jardin");

        // Initialisation du panneau de boutons
        boutonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        boutonPanel.add(salon);
        boutonPanel.add(salle_de_bain);
        boutonPanel.add(chambre);
        boutonPanel.add(cuisine);
        boutonPanel.add(jardin);
        
        chambre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundImage("/media/chambre.png");
            }
        });
        
        salon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundImage("/media/salon.png");
            }
        });
        
        salle_de_bain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundImage("/media/salle de bain.png");
            }
        });
        
        cuisine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundImage("/media/cuisine.png");
            }
        });
        
        jardin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundImage("/media/Jardin.png");
            }
        });
        // Ajouter le panneau de boutons en bas de la fenêtre
        add(boutonPanel, BorderLayout.SOUTH);
    }
    private void changeBackgroundImage(String imagePath) {
        try {
            backgroundImage = ImageIO.read(getClass().getResource(imagePath));
            repaint(); // Redessiner le panel pour afficher la nouvelle image
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner l'image en arrière-plan
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

