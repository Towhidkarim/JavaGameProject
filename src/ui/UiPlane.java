package ui;

import java.util.ArrayList;

import game.GamePanel;

import java.awt.Graphics;

public class UiPlane {
    public ArrayList<UiObject> elements = new ArrayList<UiObject>();
    GamePanel gamePanel;

    public UiPlane(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        elements.add(new HealthBar(this.gamePanel));
        elements.add(new ScoreCounter(this.gamePanel));

    }

    public void update() {

    }
    

    public void render(Graphics g) {
        for(UiObject obj : elements) {
            obj.update();
            obj.render(g);
        }
    }
}
