package tamagotchi;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcranDemarrage extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private Controleur controleur = new Controleur();
    private double angle = 0; // L'angle de rotation pour l'icône Tamagotchi

    public EcranDemarrage() {
        setTitle("Bienvenue dans Dark Tamagotchi");
    
        // Utilisez les dimensions réelles de votre image ici
        setSize(new Dimension(1920, 1080)); // Remplacez 800 par la largeur et 600 par la hauteur de votre image
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        initStartScreen();
        initMenu();
        initAnimalRobotSelection();
        initAnimation(); // Initialiser l'animation

        setContentPane(cardPanel);
        cardPanel.add(initStartScreen(), "StartScreen");
        cardPanel.add(initMenu(), "Menu");
        cardPanel.add(initAnimalRobotSelection(), "AnimalRobotSelection");

        setContentPane(cardPanel);
        cardLayout.show(cardPanel, "StartScreen"); // Montre l'écran de démarrage en premier
    }


    
    private JLabel tamagotchiLabel = new JLabel() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(angle), centerX, centerY);
            g2d.setTransform(at);
            super.paintComponent(g2d);
            g2d.dispose();
        }
    };
    private void initUI() {
        JButton btnNouvellePartie = new JButton("Nouvelle Partie");
        btnNouvellePartie.addActionListener(e -> controleur.nouvellePartie());
        JButton btnJouer = new JButton("Jouer");
        btnJouer.addActionListener(e -> ouvrirJeu());
        styleButton(btnJouer, new Color(212, 175, 55));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY);
        panel.add(btnJouer);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        add(panel);
    }
    private JPanel initStartScreen() {
        // Créez un JPanel avec BorderLayout pour contenir l'image et le bouton
        JPanel startScreen = new JPanel(new BorderLayout());
        
        // Chargez l'image de fond et ajustez-la à la taille de la fenêtre
        ImageIcon backgroundIcon = new ImageIcon("/home/salma/Downloads/1_Tama.jpg");
        Image backgroundImg = backgroundIcon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImg));
        
        // Créez un JPanel transparent pour contenir le bouton "Jouer"
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Rendez-le transparent
        JButton btnJouer = new JButton("Jouer");
        btnJouer.addActionListener(e -> cardLayout.show(cardPanel, "Menu"));
        buttonPanel.add(btnJouer);
        
        // Ajoutez le JLabel avec l'image au centre du startScreen
        startScreen.add(backgroundLabel, BorderLayout.CENTER);
        
        // Ajoutez le JPanel avec le bouton au sud du startScreen
        startScreen.add(buttonPanel, BorderLayout.SOUTH);
        
        return startScreen;
    }
    
    
    

    
    
    private void initSelectionPanel() {
        JPanel selectionPanel = new JPanel();
        // Ajoutez des boutons ou d'autres composants à selectionPanel
        JButton btnAnimal = new JButton("Animal Tamagotchi");
        btnAnimal.addActionListener(e -> {
            // Logique pour choisir un animal
            // Peut-être appeler une méthode de Controleur ou changer de panneau
        });
        selectionPanel.add(btnAnimal);

        JButton btnRobot = new JButton("Robot Tamagotchi");
        btnRobot.addActionListener(e -> {
            // Logique pour choisir un robot
            // Peut-être appeler une méthode de Controleur ou changer de panneau
        });
        selectionPanel.add(btnRobot);

        // Ajoutez selectionPanel à la fenêtre ou à un CardLayout
        this.add(selectionPanel);
    }

    private void styleButton(JButton button, Color color) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Arial", Font.BOLD, 22));
        button.setMaximumSize(new Dimension(200, 100));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }

    private void ouvrirJeu() {
        EventQueue.invokeLater(() -> {
            Controleur controleur = new Controleur();
            InterfaceJeu jeu = new InterfaceJeu(controleur);
            jeu.setVisible(true);
        });
        this.dispose(); // Ferme l'écran de démarrage
    }
    public void changeView(String viewName) {
        cardLayout.show(cardPanel, viewName);
    }
    private JPanel initMenu() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(Color.DARK_GRAY);

        JButton btnNouvellePartie = new JButton("Nouvelle Partie");
        btnNouvellePartie.addActionListener(e -> cardLayout.show(cardPanel, "AnimalRobotSelection"));

        // btnNouvellePartie.addActionListener(...);

        JButton btnSetLangue = new JButton("Set Langue");
        // btnSetLangue.addActionListener(...);

        JButton btnRegleJeu = new JButton("Règle du Jeu");
        // btnRegleJeu.addActionListener(...);

        JButton btnQuitter = new JButton("Quitter");
        // btnQuitter.addActionListener(...);

        

        menuPanel.add(btnNouvellePartie);
        menuPanel.add(btnSetLangue);
        menuPanel.add(btnRegleJeu);
        menuPanel.add(btnQuitter);
        cardPanel.add(menuPanel, "Menu");

        return menuPanel;

    }
    private void initTamagotchiSelectionPanel() {
        JPanel tamagotchiSelectionPanel = new JPanel();
        tamagotchiSelectionPanel.setBackground(Color.DARK_GRAY);
        
        JButton btnAnimal = new JButton("Animal Tamagotchi");
        btnAnimal.addActionListener(e -> choisirAnimal());
        
        JButton btnRobot = new JButton("Robot Tamagotchi");
        btnRobot.addActionListener(e -> choisirRobot());
        
        tamagotchiSelectionPanel.add(btnAnimal);
        tamagotchiSelectionPanel.add(btnRobot);
        cardPanel.add(tamagotchiSelectionPanel, "TamagotchiSelection");
    }
        private void choisirAnimal() {
        // Remplacez avec la logique appropriée pour choisir un animal
        Tamagotchi animal = new Chien("NomChien", new Maison(Piece.JARDIN, new File("chemin/vers/image.jpg"), new File("chemin/vers/son.mp3")));
        controleur.addTamagotchi(animal);
        // Changez de panneau ou effectuez d'autres actions nécessaires
    }
    
    private JPanel initAnimalRobotSelection() {
        JPanel selectionPanel = new JPanel();
        
        JButton btnAnimal = new JButton("Animal Tamagotchi");
        btnAnimal.addActionListener(e -> choisirAnimal());
        selectionPanel.add(btnAnimal);

        JButton btnRobot = new JButton("Robot Tamagotchi");
        btnRobot.addActionListener(e -> choisirRobot());
        selectionPanel.add(btnRobot);

        cardPanel.add(selectionPanel, "AnimalRobotSelection");

        return selectionPanel;

    }
    private void choisirRobot() {
        // Remplacez avec la logique appropriée pour choisir un robot
        Tamagotchi robot = new Robot("NomRobot", new Maison(Piece.SALON, new File("chemin/vers/image.jpg"), new File("chemin/vers/son.mp3")));
        controleur.addTamagotchi(robot);
        // Changez de panneau ou effectuez d'autres actions nécessaires
    }
    private void initAnimation() {
        tamagotchiLabel = new JLabel(new ImageIcon("/home/salma/Downloads/1_Tama.png")) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                int centerX = this.getWidth() / 2;
                int centerY = this.getHeight() / 2;
                AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(angle), centerX, centerY);
                g2d.setTransform(at);
                g2d.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, this);
                g2d.dispose();
            }
        };
        tamagotchiLabel.setBounds(100, 100, 200, 200); // Ajustez selon la taille réelle de votre icône
        add(tamagotchiLabel);

        Timer timer = new Timer(100, e -> {
            angle += 10; // Changez cette valeur pour ajuster la vitesse de rotation
            tamagotchiLabel.repaint(); // Redessine l'icône avec le nouvel angle
        });
        timer.start();
    }
    
    public static void main(String[] args) {
        // La méthode main pour exécuter l'application
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EcranDemarrage().setVisible(true);
            }
        });
    }
    }

