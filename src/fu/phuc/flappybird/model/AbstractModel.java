package fu.phuc.flappybird.model;

public abstract class AbstractModel {
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 14/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    /**
     * x : x-axis
     * y : y-axis
     */
    private int x;
    private int y;
    private int width;
    private int height;

    public AbstractModel(){

    }

    public AbstractModel(final int xAxis, final int yAxis){
        this.x = xAxis;
        this.y = yAxis;
    }


    public AbstractModel(final int xAxis, final int yAxis, final int width, final int height){
        this.x = xAxis;
        this.y = yAxis;
        this.width = width;
        this.height = height;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
