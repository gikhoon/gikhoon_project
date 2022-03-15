package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1764 {
    void run() {
        Scanner scanner = new Scanner(System.in);
        int aLength = scanner.nextInt();
        int bLength = scanner.nextInt();
        String[] a = new String[aLength];
        String[] b = new String[bLength];
        ArrayList<String> sum = new ArrayList<>();
        for (int i = 0; i < aLength; i++) {
            a[i] = scanner.next();
        }
        for (int i = 0; i < bLength; i++) {
            b[i] = scanner.next();
            for(int j=0;j<aLength;j++){
                if(b[i].equals(a[j])){
                    sum.add(b[i]);
                }
            }
        }
        Collections.sort(sum);
        System.out.println(sum.size());
        for(int i=0;i<sum.size();i++){
            System.out.println(sum.get(i));
        }
    }
    public static void main(String[] args){
        Q1764 q1764 = new Q1764();
        q1764.run();
    }
}
