package Chapter9;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class P532_5 extends JFrame {
    P532_5(){
        Color[] colors = new Color[] {Color.WHITE, Color.GRAY,Color.RED,Color.cyan};
        setTitle("4x4 Color Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,4));
        Random r = new Random();
        for(int i=0;i<16;i++){
            JLabel jb = new JLabel(Integer.toString(i));
            jb.setBackground(colors[r.nextInt(4)]);
            jb.setOpaque(true);
            c.add(jb);
        }
        setSize(500, 300);
        setVisible(true);
    }
    public static void main(String[] args){
        new P532_5();
    }
}
