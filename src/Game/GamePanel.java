package game;

import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument.Iterator;

import entities.Enemy;
import entities.Entity;
import entities.Player;
import entities.Projectile;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import utils.Vector2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.ListIterator;

public class GamePanel extends JPanel {

    int x = 200, y = 200;
    public Player player;
    public Vector2 currentMousePos;
    public ArrayList<Entity> entityList = new ArrayList<Entity>();
    public ArrayList<Entity> listBuffer = new ArrayList<Entity>();

    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
        addMouseMotionListener(new MouseInputs(this));
        player = new Player(new Vector2(500, 500), 50 , Color.black, this);
        entityList.add(player);
        entityList.add(new Enemy(new Vector2(100, 100), 20, Color.blue, this));
        entityList.add(new Enemy(new Vector2(300, 100), 20, Color.blue, this));
        entityList.add(new Enemy(new Vector2(600, 400), 20, Color.blue, this));
        //entityList.add(new Projectile(player.pos, new Vector2(-1, -1), 10, this));

    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2d = (Graphics2D)graphics;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        update(graphics);
    }




    public void checkCollision(Entity a) {
        
        for(int i = 0; i < entityList.size(); i++) {
            Entity current = entityList.get(i);
            if(a != current)
                if(Vector2.sqDistance(a.pos, current.pos) <= Math.pow(a.radius + current.radius, 2)) {
                    a.onCollisionEnter(current);
                }
        }
        
    }

    public void update(Graphics graphics) {
        if(listBuffer.size() != 0) {
            for(int i = 0; i < listBuffer.size(); i++ ) {
                entityList.add(listBuffer.get(i));
            }
            listBuffer.clear();
        }
        player.setClosestEnemy(entityList);
        for(int i = 0; i < entityList.size(); i++) {
            Entity current = entityList.get(i);
            current.update();
            checkCollision(current);
            current.render(graphics);
        }
    }

    public void instantiate(Entity object) {
        listBuffer.add(object);
        // entityList.add(object);
    }

    public void destroy(Entity object) {
        entityList.remove(object);
    }
    
}

    

