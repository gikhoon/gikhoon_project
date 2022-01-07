package Chapter9;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
     public MyFrame() {
         setTitle("GridLayout Sample");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         GridLayout grid = new GridLayout(4,2);
         grid.setVgap(10);
         Container c = getContentPane();
         c.setLayout(grid);

         c.add(new Label("이름"));
         c.add(new JTextField(""));
         c.add(new Label("학번"));
         c.add(new JTextField(""));
         c.add(new Label("학과"));
         c.add(new JTextField(""));
         c.add(new Label("과목"));
         c.add(new JTextField(""));

         setSize(300, 200);
         setVisible(true);

     }
    public static void main(String[] args) {
        new MyFrame();
    }
}