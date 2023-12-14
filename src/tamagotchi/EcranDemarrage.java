package tamagotchi;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.geom.AffineTransform;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcranDemarrage extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private Controleur controleur = new Controleur();
    private ImageIcon iconJouer = new ImageIcon("/chemin/vers/votre/image/jouer.png"); // Assurez-vous que le chemin est correct
    private ImageIcon iconFond = new ImageIcon("/chemin/vers/votre/image/fond.png"); // Assurez-vous que le chemin est correct

    public EcranDemarrage() {
        setTitle("Bienvenue dans Dark Tamagotchi");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Plein écran
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // Enlève la barre de titre et les bordures
        initStartScreen();
        setContentPane(cardPanel);
        setVisible(true);
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
    private void initStartScreen() {
        // Utilisez OverlayLayout pour superposer le bouton sur l'image
        JPanel startScreen = new JPanel();
        startScreen.setLayout(new OverlayLayout(startScreen));
    
        // Configurez l'image de fond pour remplir la fenêtre
        ImageIcon backgroundIcon = new ImageIcon("/chemin/vers/votre/image/fullscreen.png");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        // Assurez-vous que l'image est redimensionnée en conséquence
        backgroundLabel.setSize(getWidth(), getHeight());
        backgroundLabel.setLayout(null); // Pas de layout pour pouvoir placer le bouton exactement où vous voulez
    
        // Configurez le bouton jouer
        ImageIcon jouerIcon = new ImageIcon("/chemin/vers/votre/image/jouer.png");
        JButton btnJouer = new JButton(jouerIcon);
        btnJouer.setBorderPainted(false);
        btnJouer.setContentAreaFilled(false);
        btnJouer.setFocusPainted(false);
        btnJouer.addActionListener(e -> ouvrirJeu());
        // Calculez la position et la taille après que le composant est ajouté et que la fenêtre est affichée
        btnJouer.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int boutonLargeur = jouerIcon.getIconWidth();
        int boutonHauteur = jouerIcon.getIconHeight();
        int xPosition = (getWidth() - boutonLargeur) / 2;  // Centré en largeur
        int yPosition = getHeight() - boutonHauteur - 100; // 100 pixels au-dessus du bas de la fenêtre
        btnJouer.setBounds(xPosition, yPosition, boutonLargeur, boutonHauteur);
            }
            });
    
        // Ajoutez le bouton jouer sur l'image de fond
        backgroundLabel.add(btnJouer);
        startScreen.add(backgroundLabel);
    
        // Ajoutez le startScreen au cardPanel
        cardPanel.add(startScreen, "StartScreen");
    }
    

    private void ouvrirJeu() {
        InterfaceJeu jeu = new InterfaceJeu(controleur); // Remplacez par votre logique pour ouvrir la nouvelle fenêtre
        jeu.setVisible(true);
        this.dispose(); // Fermez l'écran de démarrage
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
    private void initMenu() {
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
        Tamagotchi animal = new Chien("NomChien", new Lieu(Piece.JARDIN, new File("chemin/vers/image.jpg"), new File("chemin/vers/son.mp3")));
        controleur.addTamagotchi(animal);
        // Changez de panneau ou effectuez d'autres actions nécessaires
    }
    
    private void initAnimalRobotSelection() {
        JPanel selectionPanel = new JPanel();
        
        JButton btnAnimal = new JButton("Animal Tamagotchi");
        btnAnimal.addActionListener(e -> choisirAnimal());
        selectionPanel.add(btnAnimal);

        JButton btnRobot = new JButton("Robot Tamagotchi");
        btnRobot.addActionListener(e -> choisirRobot());
        selectionPanel.add(btnRobot);

        cardPanel.add(selectionPanel, "AnimalRobotSelection");
    }
    private void choisirRobot() {
        // Remplacez avec la logique appropriée pour choisir un robot
        Tamagotchi robot = new Robot("NomRobot", new Lieu(Piece.SALON, new File("chemin/vers/image.jpg"), new File("chemin/vers/son.mp3")));
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
        EventQueue.invokeLater(() -> {
            EcranDemarrage frame = new EcranDemarrage();
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Plein écran
            frame.setUndecorated(true); // Enlève la barre de titre et les bordures
            frame.setVisible(true);
        });
    }
    
    }

