package Game;

public class MainGame {
    GamePanel gamePanel;
    GameFrame gameFrame;

    public MainGame() {
        gamePanel = new GamePanel();
        gameFrame = new GameFrame(gamePanel);

    }
    
}
