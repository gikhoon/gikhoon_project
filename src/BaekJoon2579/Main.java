package BaekJoon2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        stairs = new int[num];
        int[] max = new int[num];
        for (int i = 0; i < num; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        if(num==1){
            System.out.println(stairs[0]);
            return;
        }
        if(num==2){
            System.out.println(stairs[1]+stairs[0]);
            return;
        }
        max[0] = stairs[0];
        max[1] = stairs[0] + stairs[1];
        max[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        for (int i = 3; i < num; i++) {
            max[i] = Math.max(max[i - 3] + stairs[i] + stairs[i - 1], max[i - 2] + stairs[i]);
        }
        System.out.println(max[num-1]);
    }
}
