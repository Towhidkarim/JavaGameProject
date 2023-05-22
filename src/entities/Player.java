package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import game.GamePanel;
import stats.PlayerStats;
import utils.Taglist;
import utils.Vector2;

public class Player extends Entity {

    public int speed = 3;
    public int size = 50;
    int count = 0;
    public Entity closestEnemy = null;
    private BufferedImage playerSprite;
    public int[][] weaponCoords = {{-75, 0}, {75, 0}};
    public PlayerStats stats;

    public Player(Vector2 pos, int radius, Color color, GamePanel gamePanel) {
        super(pos, radius, color, gamePanel);
        importImg();
        stats = new PlayerStats(100);
        gamePanel.instantiate(new Weapon(new Vector2(pos.x - 50, pos.y), 0, gamePanel));
        gamePanel.instantiate(new Weapon(new Vector2(pos.x + 50, pos.y), 1,  gamePanel));
        this.tagName = Taglist.player;
    }    

    private void importImg() {
        //InputStream stream = getClass().getResourceAsStream("/player_sprite.png");
        try {
            playerSprite = ImageIO.read(new File("assets/player_sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics graphics) {
        //graphics.drawImage(playerSprite, (int)pos.x, (int)pos.y, null);
        graphics.drawImage(playerSprite,(int) pos.x - radius, (int)pos.y - radius, radius * 2, radius * 2, null);
    }

    public void update() {
        Vector2 dist = Vector2.vectorDistance(gamePanel.currentMousePos, pos);
        Vector2 direction = dist.normalized();
        direction.multiply(speed);
        if(dist.sqrMagnitude() >= this.radius * this.radius)
        move(direction);

        size++;
        if(size >20) {
            //Vector2 random = new Vector2((float)Math.random() * 1000,(float) Math.random() * 1000);
            //gamePanel.instantiate(new Projectile(pos,closestEnemy.pos, 20, gamePanel));
            //gamePanel.entityList.add(new Enemy(new Vector2((float)Math.random() * 500, (float)Math.random() * 500), 20, Color.BLUE, gamePanel));
            //gamePanel.entityList.add(new Projectile(pos,closestEnemy.pos.normalized(), 20, gamePanel));
            //gamePanel.instantiate(new Enemy(random, 30, Color.BLUE, gamePanel));
            gamePanel.spawnEnemy();
           // gamePanel.instantiate(new Projectile2(pos, gamePanel));
            size = 0;
        }
    }
    
    public void setClosestEnemy(ArrayList<Entity> list) {
        Entity closest = null;
        double closestDistance = Double.POSITIVE_INFINITY;
        for(int i = 0; i < list.size(); i++) {
            Entity current = list.get(i);
            if(current.tagName == Taglist.enemy) {
                //double dist = Vector2.sqDistance(x.pos, pos);
                if(Vector2.sqDistance(current.pos, this.pos) < closestDistance) 
                    closest = current;
                    closestDistance = Vector2.sqDistance(current.pos, this.pos);
            }
            
        }
        closestEnemy = closest;
    }

    public Vector2 getClosestEnemyPos(Vector2 currentPos) {
        double distance = Double.POSITIVE_INFINITY;
        Vector2 enemyPos = new Vector2(0, 0);
        for(Entity x : gamePanel.entityList) {
            if(x.tagName == Taglist.enemy)
                if(Vector2.sqDistance(currentPos, x.pos) < distance) {
                    enemyPos = x.pos;
                    distance = Vector2.sqDistance(currentPos, x.pos);
                }
        }
        return enemyPos;
    }

    @Override
    public void onCollisionEnter(Entity collidedObject) {
        if(collidedObject.tagName == Taglist.enemy)
            stats.takeDamage(0.25f);
    }
}
