import java.util.LinkedList;
import java.util.Scanner;
abstract class Shape {
    private Shape next;
    public Shape(){
        next = null;
    }
    public void setNext(Shape obj) {next=obj;}
    public Shape getNext(){return next;}
    public abstract void draw();
}
class Line extends Shape{
    public void draw(){
        String name = "Line";
        System.out.println(name);
    }
}
class Rect extends Shape{
    public void draw(){
        String name = "Rect";
        System.out.println(name);
    }
}
class Circle extends Shape{
    public void draw(){
        String name = "Circle";
        System.out.println(name);
    }
}
public class P321_12_incomplete {
    private Shape head, tail;
    Scanner scanner = new Scanner(System.in);
    public P321_12_incomplete(){
        head=null;
        tail=null;
    }
    void run(){
        Shape shapeList;
        while(true){
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            int chooseMenu = scanner.nextInt();
            switch(chooseMenu){
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    int insertNum= scanner.nextInt();
                    insert(insertNum);
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치");
                    int delNum = scanner.nextInt();
                    delete(delNum);
                    break;
                case 3:
                    print();
                    break;
                case 4:
                    System.out.println("beauty를 종료합니다");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못입력하셨습니다. 다시 입력하세요");
            }
        }
    }
    void insert(int draw){
        Shape grapic = null;
        switch(draw) {
            case 1:
                grapic = new Line();
                break;
            case 2:
                grapic = new Rect();
                break;
            case 3:
                grapic = new Circle();
                break;
        }
        if(head==null){
            head=grapic;
            tail=grapic;
        }
        else{
            tail.setNext(grapic);
            tail=grapic;
        }
    }
    void print(){
        Shape s = head;
        while(s!=null){
            s.draw();
            s=s.getNext();
        }
    }
    void delete(int num){
        Shape cur = head;
        Shape tmp = head;
        int i;
        if(num==1){
            if(head==tail){
                head=null;
                tail=null;
                return;
            }
            else{
                head=head.getNext();
                return;
            }
        }
        for(i=0;i<num;i++){
            tmp=cur;
            cur=cur.getNext();
            if(cur==null){
                System.out.println("삭제할 수 없습니다");
                return;
            }
        }
        if(i==num){
            tmp.setNext(cur.getNext());
            tail=tmp;
        }
        else
            tmp.setNext(cur.getNext());
    }
    public static void main(String[] args){
        P321_12_incomplete GraphicEditor = new P321_12_incomplete();
        System.out.println("그래픽 에디터 beauty를 실행합니다");
        GraphicEditor.run();
    }
}