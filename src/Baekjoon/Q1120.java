package Baekjoon;

import java.util.Scanner;

public class Q1120 {
    void run(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        int aLength = a.length();
        int bLength = b.length();
        int indexDifferenceLength = bLength-aLength;
        int lessDifference= aLength;
        for(int i=0;i<=indexDifferenceLength;i++){
            int currentDifference =0;
            for(int j=0;j<aLength;j++){
                if(a.charAt(j)!=b.charAt(j+i)) currentDifference++;
            }
            if(currentDifference<lessDifference) lessDifference = currentDifference;
        }
        System.out.println(lessDifference);
    }
    public static void main(String[] args){
        Q1120 q1120 =new Q1120();
        q1120.run();
    }
}
