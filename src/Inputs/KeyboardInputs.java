package Inputs;

import java.awt.event.KeyListener;

import Game.GamePanel;

import java.awt.event.KeyEvent;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
       System.out.println("Hello");
    //    gamePanel.move();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    
}
