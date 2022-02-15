package fu.phuc.flappybird.view;

import fu.phuc.flappybird.controller.Game;
import fu.phuc.flappybird.controller.handlers.KeyHandler;
import fu.phuc.flappybird.controller.handlers.MouseHandler;

import javax.swing.*;

public class Window extends JFrame {
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 13/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */


    public Window(){

    }

    public Window(final int width,final int height,final String title,final Game game){
        JFrame view = new JFrame();
        view.setTitle(title);
        view.pack();
        view.setSize(width, height);
        view.setLocationRelativeTo(null);
        view.setResizable(false);
        view.setDefaultCloseOperation(3);
        view.addKeyListener(new KeyHandler());
        view.setVisible(true);
        view.add(game);
        game.start();
    }




}