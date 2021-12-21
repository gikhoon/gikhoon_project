package UI;

import java.util.*;

abstract class Shape{
    public abstract void draw();
}
class Line extends Shape{
    public void draw(){
        System.out.println("Line");
    }
}
class Rect extends Shape{
    public void draw(){
        System.out.println("Rect");
    }
}
class Circle extends Shape{
    public void draw(){
        System.out.println("Circle");
    }
}
public class P439_10 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("그래픽 에디터 beauty을 실행합니다");
        Shape shape = null;
        Vector<Shape> vector = new Vector<>();
        while(true){
            System.out.print("삽입(1), 삭제(2), 모두보기(3), 종료(4)>>");
            int chooseNum = scanner.nextInt();
            switch(chooseNum){
                case 4:
                    System.out.println("beauty를 종료합니다");
                    return;
                case 3:
                    Iterator<Shape> it = vector.iterator();
                    while(it.hasNext()){
                        it.next().draw();
                    }
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치>>");
                    int num2 = scanner.nextInt();
                    if(vector.size()==0||vector.size()<=num2) {
                        System.out.println("삭제할수 없습니다");
                        break;
                    }
                    vector.remove(num2);
                    break;
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    int num = scanner.nextInt();
                    switch(num) {
                        case 1:
                            shape = new Line();
                            break;
                        case 2:
                            shape = new Rect();
                            break;
                        case 3:
                            shape = new Circle();
                            break;
                        default:
                            System.out.println("잘못 입력했습니다");
                            break;
                    }
                    if(num>=1&&num<=3) {
                        vector.add(shape);
                        break;
                    }
                    else
                        break;
                default:
                    System.out.println("잘못 입력했습니다");
                    break;
            }
        }
    }
}
