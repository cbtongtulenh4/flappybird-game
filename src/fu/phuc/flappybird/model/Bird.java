package fu.phuc.flappybird.model;

import fu.phuc.flappybird.controller.Game;
import fu.phuc.flappybird.util.GraphicsLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird {
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 13/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    private int x;
    private int y;
    private BufferedImage[] image;
    private int imgCurrent;
    private long delay;
    private long lastTime;
    private float gravity = 0.3F;
    private float velY;

    private static final int SPACE = Game.HEIGHT_SCREEN - Ground.HEIGHT_GROUND - 33;

    public Bird(){

    }

    public Bird(final int x, final int y){
        this.x = x;
        this.y = y;
        init();
    }

    public void setVelY(float velY){
        this.velY = velY;
    }

    private void init(){
        imgCurrent = 0;
        this.velY = 0.0F;
        lastTime = System.nanoTime();
        delay = 100L;
        String[] path = new String[]{
                "D:\\JavaProject\\FlappyBird\\src\\fu\\phuc\\flappybird\\view\\bird0.png",
                "D:\\JavaProject\\FlappyBird\\src\\fu\\phuc\\flappybird\\view\\bird1.png",
                "D:\\JavaProject\\FlappyBird\\src\\fu\\phuc\\flappybird\\view\\bird2.png",
        };
        image = new BufferedImage[path.length];
        for (int i = 0; i < path.length; i++){
            image[i] = GraphicsLoader.image(path[i]);
        }
    }

    public void tick(){
        this.velY += this.gravity;
        this.y = (int) ((float)this.y + this.velY);
        if (this.velY > 12.0F){
            this.velY = 12.0F;
        }
        if (this.y > SPACE) {
            this.y = SPACE;
            this.setVelY(0.0F);
        }

        if (this.y < 0) {
            this.y = 0;
            this.setVelY(0.0F);
        }


    }

    public void render(Graphics g){
        g.drawImage(image[imgCurrent], x, y, null);
     //   this.y += 1;
        if (!Game.gameover){
            long passTime = (System.nanoTime() - lastTime) / 1000000L;
            if (passTime > delay){
                imgCurrent++;
                if (imgCurrent == image.length){
                    imgCurrent = 0;
                }
                lastTime = System.nanoTime();
            }
        }
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        while (true){
            bird.tick();
            System.out.println(bird.velY + "    " + bird.y);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
