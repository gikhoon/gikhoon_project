package Baekjoon;

import java.util.Scanner;

import static java.lang.Math.*;

class Circle{
    int x;
    int y;
    int radius;
}
public class Q1002 {
    double howLong(Circle c1,Circle c2){
        return sqrt((c1.x-c2.x)*(c1.x-c2.x)+(c1.y-c2.y)*(c1.y-c2.y));
    }
    int compare(Circle c1, Circle c2){
        double d = howLong(c1,c2);
        int r1Pr2 = c1.radius+c2.radius;
        int r1Mr2 = abs(c1.radius-c2.radius);
        if((c1.x==c2.x)&&(c1.y==c2.y)&&(c1.radius==c2.radius)) return -1;
        if(d>r1Pr2) return 0;
        if(d==r1Pr2) return 1;
        if(d==r1Mr2) return 1;
        if(d<r1Mr2) return 0;
        return 2;
    }
    void run(){
        Scanner scanner = new Scanner(System.in);
        int caseNum = scanner.nextInt();
        Circle [] circle1 = new Circle[caseNum];
        Circle [] circle2 = new Circle[caseNum];
        for(int i=0;i<caseNum;i++){
            circle1[i] = new Circle();
            circle2[i] = new Circle();
            circle1[i].x = scanner.nextInt();
            circle1[i].y = scanner.nextInt();
            circle1[i].radius = scanner.nextInt();
            circle2[i].x = scanner.nextInt();
            circle2[i].y = scanner.nextInt();
            circle2[i].radius = scanner.nextInt();
        }
        for(int i=0;i<caseNum;i++){
            int answer = compare(circle1[i],circle2[i]);
            System.out.println(answer);
        }
    }
    public static void main(String[] args){
        Q1002 q1002 = new Q1002();
        q1002.run();
    }
}
