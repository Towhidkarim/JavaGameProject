package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;
import utils.Vector2;

public class Weapon extends Entity {

    int counter = 0;
    int fireRate = 1;
    int slot;
    private BufferedImage sprite;
    private Vector2 targetPos = Vector2.up;
    private Vector2 bulletSpawnPos = new Vector2();
    private Vector2 target = new Vector2();
    private Vector2 lookDir = new Vector2();

    public Weapon(Vector2 pos,int slot ,GamePanel gamePanel) {
        super(pos, 30, Color.BLACK, gamePanel);
        this.slot = slot;
        loadImage();
        
    }
    
    private void loadImage() {
        try {
            sprite = ImageIO.read(new File("assets/weapon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        int[] offset = gamePanel.player.weaponCoords[slot];
        Vector2 newPos = new Vector2(gamePanel.player.pos.x + offset[0], gamePanel.player.pos.y + offset[1]);
        this.pos = newPos;
        target = gamePanel.player.getClosestEnemyPos(pos);
        lookDir = Vector2.vectorDistance(target, pos);
        bulletSpawnPos = lookDir.normalized();
        bulletSpawnPos.multiply(30);
        bulletSpawnPos.x += pos.x;
        bulletSpawnPos.y += pos.y;

        counter++;
        if(counter >= 25) {
            targetPos = gamePanel.player.closestEnemy.pos;
            gamePanel.instantiate(new Projectile2(bulletSpawnPos, gamePanel));
            counter = 0;
        }
    }

    public void render(Graphics g) {
        
        double angle = Math.atan2(lookDir.y, lookDir.x);
       // g.drawImage(sprite, (int)pos.x - 100, (int)pos.y, 30, 60, null);
        Graphics2D  g2d = (Graphics2D)g;
        AffineTransform backup = g2d.getTransform();
        AffineTransform at = AffineTransform.getRotateInstance(angle + (Math.PI/2), (int)pos.x, (int)pos.y);
        // System.out.println(angle);
        g2d.setTransform(at);
        g2d.drawImage(sprite, (int)pos.x - 15, (int)pos.y - 30, 30, 60, null);
        g2d.setTransform(backup);
        //g2d.drawLine((int)pos.x - 100, (int)pos.y, (int)gamePanel.player.closestEnemy.pos.x, (int)gamePanel.player.closestEnemy.pos.y);
        
    }
    
}
