package BaekJoon11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int data = Integer.parseInt(br.readLine());
            if(data==0){
                if(q.isEmpty()) sb.append(0).append("\n");
                else{
                    sb.append(q.poll()).append("\n");
                }
            }else{
                q.add(data);
            }
        }
        System.out.println(sb);
    }
}
