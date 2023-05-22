package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;

import game.GamePanel;
import utils.Taglist;
import utils.Vector2;

public class Projectile2 extends Entity {
    
    Vector2 targetDir;
    Vector2 target = new Vector2();
    double angle = 0;
    private BufferedImage sprite;
    public Projectile2(Vector2 pos, GamePanel gamePanel) {
        super(pos, 20, Color.DARK_GRAY, gamePanel);
        loadImg();
        this.tagName = Taglist.projectile;
        //this.pos = new Vector2(gamePanel.player.pos.x - 60, gamePanel.player.pos.y);
        target = gamePanel.player.getClosestEnemyPos(pos);
        this.targetDir = Vector2.vectorDistance(target, this.pos);
        Vector2 lookDir = Vector2.vectorDistance(target, pos);
        angle = Math.atan2(lookDir.y, lookDir.x);
    }
    private void loadImg() {
        try {
            sprite = ImageIO.read(new File("assets/bullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics graphics) {
        Graphics2D g2d = (Graphics2D)graphics;
        AffineTransform backup = g2d.getTransform();
        AffineTransform at = AffineTransform.getRotateInstance(angle + (Math.PI/2), (int)pos.x, (int)pos.y);
        // System.out.println(angle);
        g2d.setTransform(at);
        graphics.drawImage(sprite,(int) (pos.x - radius), (int)pos.y - radius, radius, radius* 3, null);
        g2d.setTransform(backup);

    }
    @Override
    public void update() {
        super.update();
        Vector2 v = targetDir.normalized();
        v.multiply(25);
        move(v);
        if(Vector2.vectorDistance(gamePanel.player.pos, new Vector2(0, 0)).sqrMagnitude() > 2000 * 2000)
        gamePanel.destroy(this);
    }

    public void onCollisionEnter(Entity collidedObject) {
        if(collidedObject.tagName == Taglist.enemy) {

        }
    }
    
}
