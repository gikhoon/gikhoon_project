package Chapter9;

import javax.swing.*;
import java.awt.*;

public class P533_7 extends JFrame{
    public P533_7(){
        setTitle("계산기 프레임");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("수식입력"));
        northPanel.add(new JTextField(10));
        northPanel.setBackground(Color.LIGHT_GRAY);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new GridLayout(4,4));
        for(int i=0;i<16;i++){
            JButton b = new JButton();
            String[] str = {"CE", "Enter", "+", "-", "x", "/"};
            centerPanel.add(b);
            if(i<10){
                b.setText(i+"");
            }else{
                b.setText(str[i-10]);
            }
            if(i>11){
                b.setBackground(Color.CYAN);
                b.setOpaque(true);
            }
        }

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.YELLOW);
        southPanel.add(new JLabel("계산결과"));
        southPanel.add(new JTextField(10));



        c.add(northPanel,BorderLayout.NORTH);
        c.add(centerPanel,BorderLayout.CENTER);
        c.add(southPanel,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new P533_7();
    }
}
