package BaekJoon1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] link;
    static int[] dist;
    static int city;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        link = new ArrayList[city + 1];
        dist = new int[city + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= city; i++) link[i] = new ArrayList<>();

        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            link[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        dijkstra(startCity);

        System.out.println(dist[endCity]);

    }
    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] s = new boolean[city + 1];
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Node currentNode = q.poll();
            int end = currentNode.end;

            if(s[end]) continue;
            s[end]= true;

            for(Node node:link[end]){
                if(dist[node.end]>dist[end]+node.weight){
                    dist[node.end] = dist[end]+node.weight;
                    q.add(new Node(node.end, dist[node.end]));
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