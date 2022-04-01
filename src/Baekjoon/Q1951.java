package Baekjoon;

import java.util.Scanner;

public class Q1951 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String stringNum = String.valueOf(num);
        int numLength = stringNum.length();
        long neededTypeNum = 0;
        for(int i=0;i<numLength;i++) {
            neededTypeNum += (num + 1 - Math.pow(10, i));
        }
        int x = 10;
        int y = 8;
        int percent = (int)((y/x)*100);
        double k = (((percent+1)*x)-(100*y))/(99-percent);
        System.out.println(neededTypeNum);
    }
}
