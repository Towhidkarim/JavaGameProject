package entities;

import java.awt.Color;
import java.awt.Graphics;

import game.GamePanel;
import utils.Vector2;

public class Entity {
    public Vector2 pos;
    public int radius = 0;
    public Color color;
    public int moveX = 0;
    public int moveY = 0;
    public boolean moving = false;
    GamePanel gamePanel;

    public Entity(Vector2 pos, int radius, Color color, GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.radius = radius * 2;
        this.pos = pos;
        this.color = color;
        
    }

    public void render(Graphics graphics) {
        graphics.fillArc((int)pos.x - radius/2, (int)pos.y - radius/2, radius, radius, 0, 360);
        graphics.setColor(color);
    }

    public void update() {
        
    }
    public void move(Vector2 direction) {
        this.pos.add(direction);
    }
    
}
