package ui;

import game.GamePanel;
import utils.Vector2;
import java.awt.Graphics;

public abstract class UiObject {
    public GamePanel gamePanel;

    public UiObject(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public abstract void update();
    public abstract void render(Graphics g);
    


}
