package Baekjoon;

import java.util.Scanner;

public class Q1015 {
    void run() {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] p = new int[length];
        int[] s = new int[length];
        for (int i = 0; i < length; i++) {
            p[i] = scanner.nextInt();
        }
        int count = 0;
        s[0] = 0;
        for(int i=1;i<length;i++){
            count = 0;
            for(int j=0;j<i;j++){
                if(p[i]<p[j]){
                    s[j]++;
                }
                else{
                    count++;
                }
            }
            s[i]=count;
        }
        for(int i=0;i<length;i++){
            System.out.print(s[i]+" ");
        }
    }
    public static void main(String[] args){
    Q1015 q1015 = new Q1015();
    q1015.run();
    }
}
