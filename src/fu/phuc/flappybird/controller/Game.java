package fu.phuc.flappybird.controller;


import fu.phuc.flappybird.controller.handlers.BarrierHandler;
import fu.phuc.flappybird.controller.handlers.KeyHandler;
import fu.phuc.flappybird.controller.handlers.MouseHandler;
import fu.phuc.flappybird.model.Barrier;
import fu.phuc.flappybird.model.Bird;
import fu.phuc.flappybird.model.Button;
import fu.phuc.flappybird.model.Ground;
import fu.phuc.flappybird.util.FpsCounter;
import fu.phuc.flappybird.view.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends Canvas {
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 13/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */

    public static final int WIDTH_SCREEN = 400;
    public static final int HEIGHT_SCREEN = 700;

    public static BufferedImage background;
    public static BufferedImage img_gameover;
    public static Bird bird;
    public static Ground ground;
    public static BarrierHandler barrier;
    public static Button buttonGo;
    public static FpsCounter fpsCounter;

    public static boolean RUNNING = true;
    public static int score;
    public static boolean gameover;


    public Game(){

    }

    public static void main(String[] args) {
        new Window(WIDTH_SCREEN, HEIGHT_SCREEN, "Flappy Bird", new Game());
    }

    public void start(){
        run();
    }

    public void init(){
        try {
            score = 0;
            gameover = false;
            background = ImageIO.read(new File("D:\\JavaProject\\FlappyBird\\src\\fu\\phuc\\flappybird\\view\\background.png"));
//            background = ImageIO.read(this.class.getResourceAsStream("/background.png"));
            img_gameover = ImageIO.read(new File("D:\\JavaProject\\FlappyBird\\src\\fu\\phuc\\flappybird\\view\\gameover.png"));
            bird = new Bird(50, 0);
            ground = new Ground();
            barrier = new BarrierHandler();
            buttonGo = new Button(138, 200, 156, 87);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void tick(){
        if (!gameover){
            bird.tick();
            ground.tick();
        }
    }

    /**
     * BufferStrategy: https://stackoverflow.com/questions/13590002
     *
     */
    void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
        }
        else {
            Graphics graphics = bs.getDrawGraphics();
            graphics.drawImage(background, 0, 0, null);
            ground.render(graphics);
            bird.render(graphics);
            barrier.run(graphics, bird);
            if (gameover){
                graphics.drawImage(img_gameover, 72, 130, null);
                buttonGo.render(graphics);
            }
            graphics.setFont(new Font("Arial", 1, 30));
            graphics.setColor(Color.WHITE);
            graphics.drawString("FPS: " + (int)fpsCounter.getAggFps(), 0, 40);
            graphics.drawString("SCORE: " + score, 0, 80);
            graphics.dispose();
            bs.show();
        }
    }

    void run(){
        init();
        this.addKeyListener(new KeyHandler());
        this.addMouseListener(new MouseHandler());
        long pastTime = System.nanoTime();
        double amountOfTicks = 60.0D;
        double ns = 1.0E9D / amountOfTicks;
        double delta = 0.0D;
        long lastTime = System.nanoTime();
        int tick = 0;
        fpsCounter = new FpsCounter();
        while (RUNNING){
            long now = System.nanoTime();
            delta += (double)(now - pastTime) / ns;

            for(pastTime = now; delta > 0.0D; --delta) {
                this.tick();
//                tick++;
               // System.out.println("Tick: " + tick + ", Delta: " + delta);
                this.render();
                fpsCounter.nextFrame();
//                if (System.nanoTime() - lastTime > 1000000000L){
//                    System.out.println("FPS: " + (int)fpsCounter.getAggFps());
//                    lastTime = System.nanoTime();
//                }
            }
//            if (tick > 0){
//         //       System.out.println("Tick: " + tick + ", Delta: " + delta);
//                tick = 0;
//            }
        }
    }


}
