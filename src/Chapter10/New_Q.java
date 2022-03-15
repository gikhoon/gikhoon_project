package Chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class New_Q extends JFrame {
    private JLabel la = new JLabel("안녕하세요");
    public New_Q(){
        setTitle("Key cord 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.GRAY);
        c.addKeyListener(new MyKeyListener());
        c.add(la);
        setVisible(true);
        setSize(300,500);
        c.setFocusable(true);
        c.requestFocus();
    }
    class MyKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            Container contentPane = (Container)e.getSource();
            la.setText(KeyEvent.getKeyText(e.getKeyCode())+"키가 입력되었음");
            if(e.getKeyCode() == KeyEvent.VK_F1){
                contentPane.setBackground(Color.GREEN);
            }
            if(e.getKeyChar()=='%'){
                contentPane.setBackground(Color.YELLOW);
            }
        }
    }
    public static void main(String[] args){
        new New_Q();
    }
}
