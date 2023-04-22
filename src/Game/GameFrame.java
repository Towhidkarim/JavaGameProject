package Game;

import javax.swing.JFrame;
//import javax.swing.JPanel;


public class GameFrame {
    
    JFrame jframe;

    public GameFrame(GamePanel gamePanel) {
        jframe = new JFrame();
        this.jframe.add(gamePanel);
        jframe.setSize(500, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}
