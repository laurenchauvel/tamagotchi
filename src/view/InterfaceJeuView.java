package view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class InterfaceJeuView extends JPanel {

    private Image backgroundImage;
    private JButton bouton1;
    private JButton bouton2;
    private JButton bouton3;
    private JButton bouton4;
    private JButton bouton5;
    private JPanel boutonPanel;

    public InterfaceJeuView(View frame) {
        // Configuration du layout du panneau principal
        setLayout(new BorderLayout());

        // Charger l'image d'arrière-plan
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/media/salon.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Initialisation des boutons
        bouton1 = new JButton("Salon");
        bouton2 = new JButton("Salle de bain");
        bouton3 = new JButton("Chambre");
        bouton4 = new JButton("Cuisine");
        bouton5 = new JButton("Jardin");

        // Initialisation du panneau de boutons
        boutonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        boutonPanel.add(bouton1);
        boutonPanel.add(bouton2);
        boutonPanel.add(bouton3);
        boutonPanel.add(bouton4);
        boutonPanel.add(bouton5);

        // Ajouter le panneau de boutons en bas de la fenêtre
        add(boutonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner l'image en arrière-plan
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
