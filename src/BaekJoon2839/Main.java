package BaekJoon2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int c5,c3;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        c5=m/5;
        c3=0;
        switch (m%10){
            case 0:
            case 5:
                break;
            case 1:
            case 6:
                c5-=1;
                c3=2;
                break;
            case 2:
            case 7:
                c5-=2;
                c3=4;
                break;
            case 3:
            case 8:
                c3=1;
                break;
            case 4:
            case 9:
                c5-=1;
                c3=3;
                break;
        }
        if(c5<0){
            System.out.println("-1");
        } else{
            System.out.println(c3+c5);
        }
    }
}
