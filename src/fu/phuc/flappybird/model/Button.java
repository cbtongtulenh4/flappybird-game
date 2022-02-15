package fu.phuc.flappybird.model;

import fu.phuc.flappybird.controller.Game;
import fu.phuc.flappybird.controller.handlers.BarrierHandler;
import fu.phuc.flappybird.util.GraphicsLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button extends AbstractModel{
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 14/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    private BufferedImage image;

    public Button(){
        super();
    }

    public Button(final int xAxis, final int yAxis){
        super(xAxis, yAxis);
        init();
    }

    public Button(final int xAxis, final int yAxis, final int width, final int height){
        super(xAxis, yAxis, width, height);
        init();
    }

    private void init(){
        this.image = GraphicsLoader.image("D:\\JavaProject\\FlappyBird\\src\\fu\\phuc\\flappybird\\view\\playbutton.png");
    }

    public void tick(Point p){
        if (p.x > this.getX() && p.x < this.getWidth() + this.getX()
                && p.y > this.getY() && p.y < this.getY() + this.getHeight()){
            Game.score = 0;
            Game.gameover = false;
            Game.bird.setX(50);
            Game.bird.setY(0);
            Game.barrier = new BarrierHandler();
        }
    }

    public void render(Graphics g){
        g.drawImage(this.image, this.getX(), this.getY(), null);
    }

}
