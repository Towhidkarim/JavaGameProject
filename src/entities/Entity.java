package entities;

import java.awt.Color;
import java.awt.Graphics;

import game.GamePanel;
import utils.Vector2;

public abstract class Entity {
    public Vector2 pos;
    public int radius = 0;
    public Color color;
    public boolean moving = false;
    GamePanel gamePanel;
    public String tagName = "default";

    public Entity(Vector2 pos, int radius, Color color, GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.radius = radius / 2;
        this.pos = pos;
        this.color = color;
        
    }

    public void render(Graphics graphics) {
        graphics.fillArc((int)pos.x - radius, (int)pos.y - radius, radius * 2 , radius * 2, 0, 360);
        graphics.setColor(color);
    }

    public void update() {
        
    }
    public void move(Vector2 direction) {
        this.pos.add(direction);
    }

    public void onCollisionEnter(Entity collidedObject) {

    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    
}
