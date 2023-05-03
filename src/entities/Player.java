package entities;

import java.awt.Color;
import java.util.ArrayList;

import game.GamePanel;
import utils.Taglist;
import utils.Vector2;

public class Player extends Entity {

    public int speed = 3;
    public int size = 50;
    int count = 0;
    public Entity closestEnemy = null;

    public Player(Vector2 pos, int radius, Color color, GamePanel gamePanel) {
        super(pos, radius, color, gamePanel);
        this.tagName = Taglist.player;
    }    

    public void update() {
        Vector2 dist = Vector2.vectorDistance(gamePanel.currentMousePos, pos);
        Vector2 direction = dist.normalized();
        direction.multiply(speed);
        if(dist.sqrMagnitude() >= this.radius * this.radius)
        move(direction);

        size++;
        if(size >60) {
            Vector2 random = new Vector2((float)Math.random() * 1000,(float) Math.random() * 1000);
            //gamePanel.instantiate(new Projectile(pos,closestEnemy.pos, 20, gamePanel));
            //gamePanel.entityList.add(new Enemy(new Vector2((float)Math.random() * 500, (float)Math.random() * 500), 20, Color.BLUE, gamePanel));
            //gamePanel.entityList.add(new Projectile(pos,closestEnemy.pos.normalized(), 20, gamePanel));
            gamePanel.instantiate(new Enemy(random, 20, Color.BLUE, gamePanel));
            if(closestEnemy != null)
            gamePanel.instantiate(new Projectile2(pos, gamePanel));
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
                if(closestDistance >= Vector2.sqDistance(current.pos, this.pos)) 
                    closest = current;
            }
            
        }
        closestEnemy = closest;
    }
}
