package tamagotchi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceJeu extends JFrame {
    private JButton btnNouvellePartie;
    private JButton btnMonTamagotchi;
    private JButton btnQuitter;
    private Tamagotchi monTamagotchi;

    public InterfaceJeu() {
        setTitle("Dark Tamagotchi");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY); // Couleur de fond

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10)); // Grid layout avec espacement
        panel.setBackground(Color.LIGHT_GRAY); // Même couleur de fond que la fenêtre
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150)); // Marges

        btnNouvellePartie = new JButton("Nouvelle Partie");
        btnMonTamagotchi = new JButton("Mon Tamagotchi");
        btnQuitter = new JButton("Quitter");

        styleButton(btnNouvellePartie, Color.GREEN);
        styleButton(btnMonTamagotchi, Color.ORANGE);
        styleButton(btnQuitter, Color.RED);

        panel.add(btnNouvellePartie);
        panel.add(btnMonTamagotchi);
        panel.add(btnQuitter);

        btnNouvellePartie.addActionListener(e -> {
            // Implémentation de code pour nouvelle partie
        });

        btnMonTamagotchi.addActionListener(e -> {
            // Implémentation de code pour "Mon Tamagotchi"
        });

        btnQuitter.addActionListener(e -> System.exit(0));

        add(panel, BorderLayout.CENTER);
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setOpaque(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            InterfaceJeu jeu = new InterfaceJeu();
            jeu.setVisible(true);
        });
    }
}
