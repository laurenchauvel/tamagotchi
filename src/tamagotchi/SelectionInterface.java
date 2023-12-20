package tamagotchi;

import javax.swing.*;

import tamagotchi.Controleur.Espece;

import java.awt.*;
import java.io.File;

public class SelectionInterface extends JFrame {
    private Controleur controleur;

    public SelectionInterface(Controleur controleur) {
        this.controleur = controleur;
        setTitle("Sélectionnez votre Tamagotchi");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI(this.controleur);
    }

    private void initUI(Controleur controleur) {
        JButton btnAnimal = new JButton("Animal Tamagotchi");
        btnAnimal.addActionListener(e -> choisirAnimal());

        JButton btnRobot = new JButton("Robot Tamagotchi");
        btnRobot.addActionListener(e -> choisirRobot());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(btnAnimal);
        panel.add(btnRobot);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        add(panel);
    }

    private void choisirAnimal() {
        // Logique pour choisir un Tamagotchi animal
        Tamagotchi animal = new Chien("NomChien", new Maison(Piece.JARDIN, new File("/home/salma/Downloads/Jardin.jpg"), new File("/home/salma/Downloads/Jardin.mp3")));
        controleur.addTamagotchi(animal);
        ((EcranDemarrage)SwingUtilities.getWindowAncestor(this)).changeView("GamePanel"); // Changement de vue

    }

    private void choisirRobot() {
        // Logique pour choisir un Tamagotchi robot
        Tamagotchi robot = new Robot("NomRobot", new Maison(Piece.SALON, new File("/home/salma/Downloads/Jardin.jpg"), new File("/home/salma/Downloads/Jardin.mp3")));
        controleur.addTamagotchi(robot);
        dispose(); // Ferme la fenêtre de sélection
        new InterfaceJeu(controleur).setVisible(true); // Ouvre l'interface du jeu
    }


}
