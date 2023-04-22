package Game;

import javax.swing.JPanel;

import Inputs.KeyboardInputs;

import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel {

    int x = 200, y = 200;

    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawRect(x, y, 100, 200);
    }


    public void move() {
        //repaint();
        x += (int)1 * 0.016667;

    }
    
}

    

