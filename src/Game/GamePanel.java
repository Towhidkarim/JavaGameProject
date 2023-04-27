package game;

import javax.swing.JPanel;

import entities.Enemy;
import entities.Entity;
import entities.Player;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import utils.Vector2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
// import java.awt.Color;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    int x = 200, y = 200;
    public Player player;
    public Vector2 currentMousePos;
    public ArrayList<Entity> entityList = new ArrayList<Entity>();

    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
        addMouseMotionListener(new MouseInputs(this));
        player = new Player(new Vector2(500, 500), 50 , Color.black, this);
        entityList.add(player);
        entityList.add(new Enemy(new Vector2(100, 100), 20, Color.blue, this));
        entityList.add(new Enemy(new Vector2(300, 100), 20, Color.blue, this));
        entityList.add(new Enemy(new Vector2(600, 400), 20, Color.blue, this));

    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2d = (Graphics2D)graphics;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        
        // graphics.drawRect(x, y, 100, 200);
        //graphics.fillArc(x, y, 100, 100, 0, 360);
        for(Entity x: entityList) {
            x.update();
            x.render(graphics);
        }
    }


    public void move() {
        //repaint();
        x += (int)1 * 0.016667;

    }

    public void update() {
        
    }
    
}

    

