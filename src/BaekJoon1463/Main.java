package BaekJoon1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] intArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        intArray = new Integer[N + 1];
        intArray[0]=intArray[1]=0;

        Cal(N);

        System.out.println(intArray[N]);
    }
    static int Cal(int num){
        if(intArray[num]!=null) return intArray[num];
        if(num%6==0) intArray[num] = Math.min(Math.min(Cal(num / 2), Cal(num / 3)), Cal(num - 1)) + 1;
        else if(num%3==0) intArray[num] = Math.min(Cal(num / 3), Cal(num - 1)) + 1;
        else if(num%2==0) intArray[num] = Math.min(Cal(num / 2), Cal(num - 1)) + 1;
        else intArray[num] = Cal(num-1) + 1;

        return intArray[num];
    }
}

