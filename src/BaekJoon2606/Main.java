package BaekJoon2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(br.readLine());
        graph = new boolean[node+1][node+1];
        isVisited = new boolean[node+1];
        int edge = Integer.parseInt(br.readLine());

        for(int i=0;i<edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end]=true;
            graph[end][start]=true;
        }
        int currentNode = 1;
        int count = 0;
        isVisited[1]=true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            currentNode=q.peek();
            for(int i=1;i<=node;i++){
                if(!isVisited[i]&&graph[currentNode][i]){
                    count++;
                    q.add(i);
                    isVisited[i]=true;
                }
            }
            q.poll();
        }
        System.out.println(count);
    }
}
