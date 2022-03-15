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
        int addFirstLetterError = 0;
        int addLastLetterError = 0;
        for(int i=0;i<aLength;i++){
            if(a.charAt(i)!=b.charAt(i)){
                addLastLetterError++;
            }
        }
        a=b.substring(0,indexDifferenceLength)+a;
        for(int i=0;i<bLength;i++){
            if(a.charAt(i)!=b.charAt(i)){
                addFirstLetterError++;
            }
        }
        int difference;
        if(addFirstLetterError>addLastLetterError) difference=addLastLetterError;
        else difference=addFirstLetterError;
        System.out.println(difference);
    }
    public static void main(String[] args){
        Q1120 q1120 =new Q1120();
        q1120.run();
    }
}
