package BaekJoon1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] fibonacci0;
    static int[] fibonacci1;
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();

        int num = Integer.parseInt(br.readLine());


        for (int i = 0; i < num; i++) list.add(Integer.parseInt(br.readLine()));
        int max = Collections.max(list);
        fibonacci0 = new int[max + 1];
        fibonacci1 = new int[max + 1];
        fibonacci0[0]=1;
        fibonacci1[0]=0;
        if(max>=1){
            fibonacci0[1]=0;
            fibonacci1[1]=1;
        }
        for(int i=2;i<=max;i++){
            fibonacci0[i]=fibonacci0[i-1]+fibonacci0[i-2];
            fibonacci1[i]=fibonacci1[i-1]+fibonacci1[i-2];
        }

        for(int i=0;i<num;i++){
            System.out.println(fibonacci0[list.get(i)]+" "+fibonacci1[list.get(i)]);
        }
    }
}
