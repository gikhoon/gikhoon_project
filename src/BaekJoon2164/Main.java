package BaekJoon2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());
        if(num==1){
            System.out.println("1");
            return;
        }
        for(int i=1;i<=num;i++){
            q.offer(i);
        }
        while(true){
            q.poll();
            if(q.size()==1){
                System.out.println(q.peek());
                break;
            }
            q.add(q.poll());
        }
    }
}
