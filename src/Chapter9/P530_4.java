package Chapter9;

import javax.swing.*;
import java.awt.*;

public class P530_4 extends JFrame {
    P530_4(){
        Color[] colors = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.cyan, Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY};
        setTitle("Let's study Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ten Color Buttons Frame");
        Container c = getContentPane();
        c.setLayout(new GridLayout(1,10));
        for(int i=0;i<10;i++){
            JButton jb = new JButton(Integer.toString(i));
            jb.setBackground(colors[i]);
            c.add(jb);
        }
        setSize(500,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new P530_4();
    }
}
