package view;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class GradientButton extends JButton {

    public GradientButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false); // Enlève la bordure de focus autour du bouton
        setForeground(Color.WHITE); // Texte en blanc
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(
                0, 0, Color.BLACK,
                getWidth(), getHeight(), new Color(128, 0, 128)
        );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g2d);
        g2d.dispose();
    }
}
