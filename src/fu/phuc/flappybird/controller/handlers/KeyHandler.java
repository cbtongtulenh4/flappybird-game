package fu.phuc.flappybird.controller.handlers;

import fu.phuc.flappybird.controller.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 14/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 32){
            Game.bird.setVelY(-5.0F);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
