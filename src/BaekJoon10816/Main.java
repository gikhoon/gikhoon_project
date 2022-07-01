package BaekJoon10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static HashMap<Integer, Integer> h = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<num;i++){
            int data = Integer.parseInt(st.nextToken());
            if(h.containsKey(data)) h.replace(data,h.get(data)+1);
            else h.put(data, 1);
        }
        num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<num;i++){
            int data = Integer.parseInt(st.nextToken());
            if(h.containsKey(data)) sb.append(h.get(data)).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
