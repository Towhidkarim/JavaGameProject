package game;

import javax.swing.JFrame;
//import javax.swing.JPanel;

import utils.Vector2;


public class GameFrame {
    
    JFrame jframe;
    public final Vector2 resolution = new Vector2(1280, 720);

    public GameFrame(GamePanel gamePanel) {
        jframe = new JFrame("Survival");
        this.jframe.add(gamePanel);
        jframe.setSize((int)resolution.x, (int)resolution.y);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
