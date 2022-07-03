package BaekJoon10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Stack<Integer> list = new Stack<>();
        for(int i=0;i<num;i++){
            int data = Integer.parseInt(br.readLine());
            if(data==0) list.pop();
            else list.push(data);
        }
        int sum=0;
        while(!list.isEmpty()) sum+=list.pop();
        System.out.println(sum);
    }
}
