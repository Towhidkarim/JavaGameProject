package ui;

import java.awt.Graphics;

import game.GamePanel;
import utils.Vector2;

public class ScoreCounter extends UiObject {

    int score = 0;
    public ScoreCounter(GamePanel gamePanel) {
        super(gamePanel);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void update() {
        score = gamePanel.player.stats.score;
        
    }

    @Override
    public void render(Graphics g) {
        g.setFont(g.getFont().deriveFont(40f));
        g.drawString(Integer.toString(score), 800, 30+40);
        
    }
    
}
