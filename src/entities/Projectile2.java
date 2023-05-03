package entities;

import java.awt.Color;

import game.GamePanel;
import utils.Taglist;
import utils.Vector2;

public class Projectile2 extends Entity {
    
    Vector2 targetDir;
    public Projectile2(Vector2 pos, GamePanel gamePanel) {
        super(pos, 10, Color.DARK_GRAY, gamePanel);
        this.tagName = Taglist.projectile;
        this.pos = new Vector2(gamePanel.player.pos.x - 60, gamePanel.player.pos.y);
        this.targetDir = Vector2.vectorDistance(gamePanel.player.closestEnemy.pos, this.pos);
    }
    @Override
    public void update() {
        // TODO Auto-generated method stub
        super.update();
        Vector2 v = targetDir.normalized();
        v.multiply(10);
        move(v);
        if(Vector2.vectorDistance(gamePanel.player.pos, new Vector2(0, 0)).sqrMagnitude() > 2000 * 2000)
        gamePanel.destroy(this);
    }
    
}
