package BaekJoon1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MakeWithPriorityQueue {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<num;i++){
            int data = Integer.parseInt(br.readLine());
            if(data==0) {
                if(queue.isEmpty()) sb.append(0).append("\n");
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else{
                queue.add(data);
            }
        }
        System.out.println(sb);
    }
}
