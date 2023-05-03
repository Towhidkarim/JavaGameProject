package entities;

import java.awt.Color;

import game.GamePanel;
import utils.Taglist;
import utils.Vector2;

public class Enemy extends Entity {
    int count = 0;

    public Enemy(Vector2 pos, int radius, Color color, GamePanel gamePanel) {
        super(pos, radius, color, gamePanel);
        setTagName(Taglist.enemy);

    }

    public void update() {
        move(Vector2.vectorDistance(gamePanel.player.pos, pos).normalized());
    }
    
    @Override
    public void onCollisionEnter(Entity collidedObject) {
        //if(collidedObject.tagName == "player")
        if(collidedObject.tagName == Taglist.projectile)
            gamePanel.destroy(this);
            if(collidedObject.tagName != Taglist.player)
            gamePanel.destroy(collidedObject);
        
    }
}
