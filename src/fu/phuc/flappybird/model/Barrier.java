package fu.phuc.flappybird.model;

import fu.phuc.flappybird.controller.Game;
import fu.phuc.flappybird.util.GraphicsLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Barrier{
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 14/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    private Tube above;
    private Tube below;

    public Barrier(){

    }

    public Barrier(final int xAxis, final int heightAbove, final int heightBelow){
        BufferedImage aboveImg = GraphicsLoader.image("D:\\JavaProject\\FlappyBird\\src\\fu\\phuc\\flappybird\\view\\tubebottomdown.png");
        BufferedImage belowImg = GraphicsLoader.image("D:\\JavaProject\\FlappyBird\\src\\fu\\phuc\\flappybird\\view\\tubebottomtop.png");
        this.above = new Tube(xAxis, 0, heightAbove, heightAbove, aboveImg);
        int yAxisBelow = Game.HEIGHT_SCREEN - Ground.HEIGHT_GROUND - heightBelow;
        this.below = new Tube(xAxis, yAxisBelow, yAxisBelow, heightBelow, belowImg);
    }

    private void init(){

    }

    public void tick(){
        this.above.setX((int)((float)above.getX() - Animation.VELOCITY_LANDSCAPE));
        this.below.setX((int)((float)below.getX() - Animation.VELOCITY_LANDSCAPE));
    }

    public void render(Graphics g) {
        if (!Game.gameover){
            tick();
        }
        above.render(g);
        below.render(g);
    }

    public Tube getBelow() {
        return below;
    }

    public Tube getAbove(){
        return this.above;
    }

    public static class Tube extends AbstractModel{
        private BufferedImage bodyImg;
        private BufferedImage capImg;

    //    public static int BODY_HEIGHT; // not static class -> error ?
        public static final int BODY_WIDTH = 70;
        public static final int CAP_WIDTH = 80;
        public static final int CAP_HEIGHT = 40;

        private int bodyHeight;
        private int xCap;
        private int yCap;

        public Tube(){
            super();
        }

        public Tube(final int xAxis, final int yAxis, final int yCap, final int height, final BufferedImage capImg){
            super(xAxis, yAxis);
            this.capImg = capImg;
            this.yCap = yCap;
            this.bodyHeight = height;
            this.bodyImg = GraphicsLoader.image("D:\\JavaProject\\FlappyBird\\src\\fu\\phuc\\flappybird\\view\\tube.png");
        }

        private void init(){
            this.xCap = this.getX() - 5;
        }

        public void render(Graphics g){
            init();
            g.drawImage(this.bodyImg, this.getX(), this.getY(), BODY_WIDTH, this.bodyHeight, null);
            g.drawImage(this.capImg, this.xCap, this.yCap, CAP_WIDTH, CAP_HEIGHT, null);
        }

        public int getBodyHeight() {
            return bodyHeight;
        }

        public int checkX(){
            return this.getX() + BODY_WIDTH;
        }

        public int getHeight(){
            return this.getBodyHeight() + CAP_HEIGHT;
        }



    }

}
