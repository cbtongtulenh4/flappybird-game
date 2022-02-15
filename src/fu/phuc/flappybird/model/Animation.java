package fu.phuc.flappybird.model;

import java.awt.*;

public class Animation{
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 13/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    public static final float VELOCITY_LANDSCAPE = 3.0F;


    /**
     * loop object within a screen
     * @param obj : object of model animation
     * @param distance : distance of screen
     */
    public static void road(AbstractModel obj, final int distance){
        obj.setX((int) ((float)obj.getX() - VELOCITY_LANDSCAPE));
        if (obj.getX() + distance < 0){
            obj.setX(distance);
        }
    }

}
