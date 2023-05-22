package ui;

import game.GamePanel;
import utils.Vector2;

import java.awt.Color;
import java.awt.Graphics;

public class HealthBar extends UiObject {

    private float maxValue;
    private float currentValue;
    private float percentage;
    public HealthBar(GamePanel gamePanel) {
        super(gamePanel);

    }

    @Override
    public void update() {
        currentValue = gamePanel.player.stats.currentHealth;
        maxValue = gamePanel.player.stats.maxHealth;
        percentage = (float)currentValue/maxValue;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(29, 29, 302, 52);
        g.setColor(new Color(232, 69, 69));
        g.fillRect(30, 30, (int) ((int)300 * percentage), 50);
        
    }
    
}
