package BaekJoon10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class QueueNode{
    private int data;
    private QueueNode next;
    QueueNode(int num){
        data=num;
        next = null;
    }
    void setNext(QueueNode newNode){next = newNode;}
    QueueNode getNext(){return next;}
    int getData(){return data;}
}
class MakeQueue{
    private QueueNode front; //큐의 해드
    private QueueNode back; //큐의 마지막 노드
    private int size=0;
    MakeQueue(){
        front = null;
        back = null;
        size = 0;
    }
    int getSize(){
        return size;
    }
    void push(int num){
        QueueNode q = new QueueNode(num);
        if(front!=null){
            back.setNext(q);
        }else{
            front=q;
        }
        back=q;
        size++;
    }
    int pop(){
        if(front!=null){
            int data = front.getData();
            front = front.getNext();
            size--;
            if(size==0){back=null;}
            return data;
        }
        return -1;
    }
    int front(){
        if(front!=null){
            return front.getData();
        }
        return -1;
    }
    int back(){
        if(front!=null){
            return back.getData();
        }
        return -1;
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(bf.readLine());
        MakeQueue q = new MakeQueue();
        while(commandCount-->0){
            String command=bf.readLine();
            String[] commands = command.split(" ");
            switch (commands[0]){
                case "push":
                    q.push(Integer.parseInt(commands[1]));
                    break;
                case "pop":
                    int checkPop = q.pop();
                    System.out.println(checkPop);
                    break;
                case "size":
                    System.out.println(q.getSize());
                    break;
                case "empty":
                    if(q.getSize()==0){System.out.println("1");}
                    else{System.out.println("0");}
                    break;
                case "front":
                    System.out.println(q.front());
                    break;
                case "back":
                    System.out.println(q.back());
                    break;
                default:
                }
            }
    }
}
