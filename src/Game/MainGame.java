package Game;

public class MainGame implements Runnable{
    GamePanel gamePanel;
    GameFrame gameFrame;

    final int FPS_LIMIT = 60;
    public Thread gameLoopThread;

    public MainGame() {
        gamePanel = new GamePanel();
        gameFrame = new GameFrame(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();

    }
    public void startGameLoop() {
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }

    @Override
    public void run() {
        double frameTime = 1000000000.0 / FPS_LIMIT;
        long lastTime = System.nanoTime();

        while(true) {
            if(System.nanoTime() - lastTime >= frameTime) {
                gamePanel.repaint();
                gamePanel.x++;
                lastTime = System.nanoTime();

            }
        }
        
    }
    
}
