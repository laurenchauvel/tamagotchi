package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.Controller;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import controller.Sauvegarde;
import modele.Tamagotchi;


@SuppressWarnings("serial")
public class SauvegardesView extends JPanel {
    private Sauvegarde sauvegarde;
    private Controller controller;
    private JPanel centerPanel;
    private JButton retour;
    private Image backgroundImage;
    private View view ;

    public SauvegardesView(View frame) {
    	this.view=frame;
    	try {
            backgroundImage = ImageIO.read(getClass().getResource("/media/maison.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur de chargement de l'image de fond : " + e.getMessage());
        }
        setLayout(new BorderLayout());

        // Style du bouton retour
        retour = new JButton("Retour");
        retour.setBackground(new Color(216, 20, 20));
        JPanel retourPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        retourPanel.setOpaque(false);
        retourPanel.add(retour);
        this.add(retourPanel, BorderLayout.NORTH);

        retour.addActionListener(e -> frame.getLayout().show(frame.getPanel(), frame.getMenu()));

        // Panel central pour les boutons de sauvegarde
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        centerPanel.setOpaque(false);
        this.add(centerPanel, BorderLayout.CENTER);
      
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }


    public void showSavedGames() {
        centerPanel.removeAll();

        List<Tamagotchi> savedGames = controller.getTamagoSauvegardes();
        if (savedGames == null || savedGames.isEmpty()) {
            JLabel noSavedLabel = new JLabel("Aucun Tamagotchi sauvegardé pour l'instant.");
            noSavedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(noSavedLabel);
        } else {
            for (Tamagotchi tamagotchi : savedGames) {
                String buttonText = tamagotchi.getNom() + " : " + tamagotchi.getEspece();
                GradientButton button = new GradientButton(buttonText);
                button.setPreferredSize(new Dimension(150, 30)); // Même dimension pour tous les boutons

                button.addActionListener(e -> {
                    Options(tamagotchi);
                });

                centerPanel.add(button);
            }
        }

        // Rafraîchir l'affichage du panel central
        centerPanel.revalidate();
        centerPanel.repaint();
    }
    
    private void Options(Tamagotchi tamagotchi) {
        // Options disponibles
        String[] options = {"Jouer", "Supprimer", "Retour"};
        int response = JOptionPane.showOptionDialog(this, 
            "Que voulez-vous faire avec ce Tamagotchi ?", 
            "Options pour " + tamagotchi.getNom(),
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, options[0]);

        switch (response) {
            case 0: // Jouer
                sauvegarde.reprendrePartie(tamagotchi);
                view.getLayout().show(view.getPanel(), view.getGame());
                break;
            case 1: // Supprimer
            	controller.getdelete(tamagotchi);
                // Mise à jour de l'affichage après la suppression
                showSavedGames();
                break;
            case 2: // Retour
                // Ne rien faire, retourner à l'écran précédent
                break;
        }
    }
    public void setSauvegarde(Sauvegarde sauvegarde) {
        this.sauvegarde = sauvegarde;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}