package fu.phuc.flappybird.model;

import fu.phuc.flappybird.controller.Game;
import fu.phuc.flappybird.util.GraphicsLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ground extends AbstractModel{
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 14/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    /**
     * loop : <-- g1 <-- g2 <-- g1
     * Can this class convert to a static class?
     */
    private BufferedImage image;
    private Ground g1;
    private Ground g2;

    public static final int GROUND_ANIMATION = 499;
    public static int HEIGHT_GROUND = 100;

    public Ground(){
        super();
        this.setY(Game.HEIGHT_SCREEN - 100);
//        this.setHeight(100);
//        HEIGHT_GROUND = this.getHeight();
        this.g1 = new Ground(0, this.getY());
        this.g2 = new Ground(Ground.GROUND_ANIMATION, this.getY());
    }

    public Ground(final int xAxis, final int yAxis){
        super(xAxis, yAxis);
        init();
    }


    public Ground(final int xAxis, final int yAxis, final int width, final int height){
        super(xAxis, yAxis, width, height);
        init();
    }

    private void init(){
        this.image = GraphicsLoader.image("D:\\JavaProject\\FlappyBird\\src\\fu\\phuc\\flappybird\\view\\ground.png");
    }

    /**
     * loop alternately two Ground object
     * <-- g1 <-- g2 <-- g1
     */
    public void tick() {
        Animation.road(this.g1, this.GROUND_ANIMATION);
        Animation.road(this.g2, this.GROUND_ANIMATION);
    }

    public void render(Graphics g){
        g.drawImage(this.g1.getImage(), this.g1.getX(), this.g1.getY(), null);
        g.drawImage(this.g2.getImage(), this.g2.getX(), this.g2.getY(), null);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
