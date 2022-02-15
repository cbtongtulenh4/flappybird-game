package fu.phuc.flappybird.controller.handlers;

import fu.phuc.flappybird.controller.Game;
import fu.phuc.flappybird.model.Barrier;
import fu.phuc.flappybird.model.Bird;
import fu.phuc.flappybird.model.Ground;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BarrierHandler {
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 14/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    private static final int TUBE_SPACE = 200;
    private static final int BARRIER_SPACE = 200;
    private static final int SPACE = Game.HEIGHT_SCREEN - Ground.HEIGHT_GROUND;
    private static final int xAxis = Game.WIDTH_SCREEN + Barrier.Tube.BODY_WIDTH;

    private int xAxisLast = 0;
    private Barrier barrierFirst;

    public List<Barrier> list = new ArrayList<>();

    public Barrier createBarrier(){
        Random rand = new Random();
        int heightTubeAbove = rand.nextInt(SPACE - TUBE_SPACE - Barrier.Tube.CAP_HEIGHT * 2);
        int heightTubeBelow = SPACE - (heightTubeAbove + TUBE_SPACE);
        return new Barrier(xAxis, heightTubeAbove, heightTubeBelow);
    }

    public void loopBarrier(){
        Barrier barrier;
        if (xAxisLast == 0){
            barrier = createBarrier();
            list.add(barrier);
            xAxisLast = barrier.getAbove().getX();
//            barrierFirst = barrier;
        }
        else if(Game.WIDTH_SCREEN - xAxisLast > BARRIER_SPACE){
            barrier = createBarrier();
            list.add(barrier);
            xAxisLast = barrier.getAbove().getX();
        }
    }

    public void run(Graphics g, Bird bird){
        if (!list.isEmpty()){
            for (Barrier barrier : list) {
//                if (barrier.getAbove().getX() < -100){
//                    list.remove(barrier);
//                }
//                else {
                    barrier.render(g);
                    if (bird.getX() < barrier.getAbove().checkX()){
                        if (!checkBird(barrier, bird)) {
                            return;
                        }
                    }
            }
            xAxisLast = list.get(list.size() - 1).getAbove().getX();
        }
        loopBarrier();
    }

    public boolean checkBird(Barrier barrier, Bird bird){
        if (barrier.getAbove().getX() < bird.getX() + 50){
            if (barrier.getAbove().getHeight() > bird.getY()
                    || barrier.getBelow().getY() < bird.getY() + 36){
                Game.gameover = true;
                return false;
            }
            if (barrierFirst != barrier){
                Game.score++;
                barrierFirst = barrier;
            }
        }
        return true;
    }

}
