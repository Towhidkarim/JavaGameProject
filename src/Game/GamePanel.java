package Game;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel {


    public GamePanel() {
        
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawRect(100, 100, 100, 200);
    }
    
}

    

