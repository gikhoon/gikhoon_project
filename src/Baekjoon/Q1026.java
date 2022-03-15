package Baekjoon;

import java.util.Scanner;

public class Q1026 {
    void run() {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] a = new int[length];
        int[] b = new int[length];
        for (int i = 0; i < length; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < length; i++) {
            a[i] = scanner.nextInt();
        }
        int tmp;
        int sum =0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (b[i] > b[j]) {
                    tmp = b[i];
                    b[i] = b[j];
                    b[j] = tmp;
                }
                if (a[i] < a[j]) {
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        for(int i=0;i<length;i++){
            sum+=a[i]*b[i];
        }
        System.out.println(sum);
    }
    public static void main(String[] args){
        Q1026 q1026 = new Q1026();
        q1026.run();
    }
}
