package fu.phuc.flappybird.util;

import com.sun.deploy.util.StringUtils;


public final class FpsCounter {
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 13/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    private FpsCounter fpsCounter;

    private int averageFrameCount = 100;// Report frame rate after maxframe number of frames have been rendered
    private int frameCount;
    private long passedTime;
    private long lastTime;

    private double fpsSum;
    private double aggFps, avgFps;

    private boolean started;



    public FpsCounter(){

    }

    public FpsCounter(int averageFrameCount){
        this.averageFrameCount = averageFrameCount;
    }

    public void start(){
        this.started = true;

        this.frameCount = 0;
        this.passedTime = 0;

        this.lastTime = System.nanoTime();
    }

    public void stop(){
        this.started = false;

        this.frameCount = 0;
        this.passedTime = 0;
        this.fpsSum = 0.0;

    }


    public double nextFrame(){
        if (!this.started){
            this.start();
        }
        return this.nextFrame(System.nanoTime() - this.lastTime);
    }

    private double nextFrame(long deltaNanos){
        this.frameCount++;
        this.passedTime += deltaNanos;

        this.lastTime = System.nanoTime();
        double fps = 1.e9 / deltaNanos;
        this.fpsSum += fps;

        if(this.frameCount >= getAverageFrameCount()){
            this.aggFps = this.frameCount / (this.passedTime / 1.e9);
            this.avgFps = this.fpsSum / this.frameCount;

            this.frameCount = 0;
            this.passedTime = 0;
            this.fpsSum = 0.0;
        }
        return fps;
    }

    public FpsCounter getFpsCounter() {
        return fpsCounter;
    }

    public void setFpsCounter(FpsCounter fpsCounter) {
        this.fpsCounter = fpsCounter;
    }

    public int getAverageFrameCount() {
        return averageFrameCount;
    }

    public void setAverageFrameCount(int averageFrameCount) {
        this.averageFrameCount = averageFrameCount;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(int frameCount) {
        this.frameCount = frameCount;
    }

    public long getPassedTime() {
        return passedTime;
    }

    public void setPassedTime(long passedTime) {
        this.passedTime = passedTime;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public double getFpsSum() {
        return fpsSum;
    }

    public void setFpsSum(double fpsSum) {
        this.fpsSum = fpsSum;
    }

    public double getAggFps() {
        return aggFps;
    }

    public void setAggFps(double aggFps) {
        this.aggFps = aggFps;
    }

    public double getAvgFps() {
        return avgFps;
    }

    public void setAvgFps(double avgFps) {
        this.avgFps = avgFps;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

}
