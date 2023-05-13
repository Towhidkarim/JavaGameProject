package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;
import utils.Taglist;
import utils.Vector2;

public class Enemy extends Entity {
    int count = 0;
    private BufferedImage sprite;

    public Enemy(Vector2 pos, int radius, Color color, GamePanel gamePanel) {
        super(pos, radius, color, gamePanel);
        setTagName(Taglist.enemy);
        loadImage();

    }

    private void loadImage() {
        try {
            sprite = ImageIO.read(new File("assets/enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        move(Vector2.vectorDistance(gamePanel.player.pos, pos).normalized());
    }
    public void render(Graphics g) {
        g.drawImage(sprite, (int)pos.x,(int)pos.y, radius * 2, radius * 2, null);
    }
    
    @Override
    public void onCollisionEnter(Entity collidedObject) {
        //if(collidedObject.tagName == "player")
        if(collidedObject.tagName == Taglist.projectile)
            gamePanel.destroy(this);
            if(collidedObject.tagName == Taglist.enemy)
            gamePanel.destroy(collidedObject);
        
    }
}
