package entities;

import java.awt.Color;

import game.GamePanel;
import utils.Vector2;

public class Projectile extends Entity {

    int velocity = 2;
    Vector2 targetDirection;

    public Projectile(Vector2 pos, Vector2 targerDir, GamePanel gamePanel) {
        super(pos, 10, Color.PINK, gamePanel); 
        this.targetDirection = targerDir;      
        this.pos = new Vector2(2 + 200, 200);
    }

    @Override
    public void update() {
        Vector2 dirspeed = targetDirection;
        dirspeed.multiply(velocity);
        move(targetDirection);
        // System.out.println(gamePanel.player.closestEnemy.pos.normalized().x);

        if(Vector2.sqDistance(gamePanel.player.pos, pos) >= 700 * 700);
            gamePanel.destroy(this);
    }
    
}
