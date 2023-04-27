package entities;

import java.awt.Color;

import game.GamePanel;
import utils.Vector2;

public class Player extends Entity {

    public int speed = 3;
    public int size = 50;

    public Player(Vector2 pos, int radius, Color color, GamePanel gamePanel) {
        super(pos, radius, color, gamePanel);
    }    

    public void update() {
        Vector2 dist = Vector2.vectorDistance(gamePanel.currentMousePos, pos);
        Vector2 direction = dist.normalized();
        direction.multiply(speed);
        if(dist.sqrMagnitude() >= size * size)
        move(direction);
    }
}
