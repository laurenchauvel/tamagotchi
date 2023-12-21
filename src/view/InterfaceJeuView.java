package view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class InterfaceJeuView extends JPanel {

    private Image backgroundImage;

    public InterfaceJeuView(View frame) {

        // Ajout du panneau d'arrière-plan
        try {
        	backgroundImage = ImageIO.read("../media/salon.png");
            
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // l'image en arrière-plan
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

 

    public static void main(String[] args) {
        InterfaceJeuView frame = new InterfaceJeuView();
        frame.setVisible(true);
    }
}
