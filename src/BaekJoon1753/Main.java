package BaekJoon1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int node;
    static List<Node>[] list2;
    static boolean[] s;
    static int[] Dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        int vertex = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());

        list2=new ArrayList[node+1];
        s = new boolean[node + 1];
        Dist = new int[node + 1];
        Arrays.fill(Dist,99999999);

        for(int i=1;i<=node;i++) list2[i]=new ArrayList<>();

        for(int i=0;i<vertex;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end  = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list2[start].add(new Node(end, weight));
        }

        dijkstra(startNode);

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=node;i++){
            if(Dist[i]>=99999999) sb.append("INF").append("\n");
            else sb.append(Dist[i]).append("\n");
        }
        System.out.println(sb);


    }


    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        Dist[start]=0;

        while(!q.isEmpty()){
            Node current = q.poll();
            int cur = current.end;

            if(s[cur]) continue;
            s[cur]=true;

            for(Node node:list2[cur]){
                if(Dist[node.end]>Dist[cur]+node.weight){
                    Dist[node.end] = Dist[cur]+node.weight;
                    q.add(new Node(node.end, Dist[node.end]));
                }
            }
        }
    }

}
class Node implements Comparable<Node>{
    int end;
    int weight;

    Node(int end,int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight-o.weight;
    }
}
