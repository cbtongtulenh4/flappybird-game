package fu.phuc.flappybird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class Test implements MouseListener {
    /**
     * @Project: FlappyBird
     * @Author: Fu.Minh_Phuc on 14/02/2022
     * @Github: https://github.com/cbtongtulenh4
     * @ModifiedBy:
     */



    public static void main(String[] args) {
        //Setting the Frame and Labels
        Canvas f = new Canvas();
        JFrame j = new JFrame("Test");
        j.setSize(500, 670);
        j.add(f);
        f.addMouseListener(new Test());
//        f.setLayout(new FlowLayout());
//        f.setSize(500, 500);
//        Label l = new Label();
//        l.setText("This is a demonstration");
//        f.add(l);
        j.setVisible(true);
        BufferStrategy bs = f.getBufferStrategy();
        if (bs == null){
            f.createBufferStrategy(3);
        }
        else {

            bs.show();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + " - " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
