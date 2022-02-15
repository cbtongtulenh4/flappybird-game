package fu.phuc.flappybird.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsLoader {
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 13/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    public static BufferedImage image(final String path){
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Error read image: \n" + e.getMessage());
        }
        return bufferedImage;
    }


}
