package Chapter9;

import javax.swing.*;
import java.awt.*;

public class P532_6 extends JFrame {
    public P532_6(){
        setTitle("Random Labels");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(null);
        for(int i=0;i<20;i++){
            int x = (int)(Math.random()*200)+50;
            int y = (int)(Math.random()*200)+50;
            JLabel label = new JLabel();
            label.setSize(10,10);
            label.setOpaque(true);
            label.setBackground(Color.blue);
            label.setLocation(x,y);
            c.add(label);
        }
        setVisible(true);
    }
    public static void main(String[] args){
        new P532_6();
    }
}
