package entities;

import java.awt.Color;

import game.GamePanel;
import utils.Vector2;

public class Enemy extends Entity {

    public Enemy(Vector2 pos, int radius, Color color, GamePanel gamePanel) {
        super(pos, radius, color, gamePanel);
        //TODO Auto-generated constructor stub
    }

    public void update() {
        move(Vector2.vectorDistance(gamePanel.player.pos, pos).normalized());
    }
    
}
