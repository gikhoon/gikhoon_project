package BaekJoon1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] list;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new boolean[N + 1][N + 1];
        int Min = (N+1)*N;
        int MinNode = N+1;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a][b]=true;
            list[b][a]=true;
        }

        for(int i=1;i<=N;i++){
            int sum=0;
            for(int j=1;j<=N;j++) sum+=BFS(i,j);
            if(sum<Min){
                Min=sum;
                MinNode=i;
            }
        }

        System.out.println(MinNode);
    }
    static int BFS(int start,int end){
        if(start==end) return 0;

        Queue<Node> q = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];
        isVisited[start]=true;

        q.add(new Node(start,0));
        while(!q.isEmpty()){
            Node n = q.poll();
            for(int i=1;i<=N;i++){
                if(list[n.data][end]) return n.length+1;
                if(!isVisited[i]&&list[n.data][i]){
                    isVisited[i]=true;
                    q.add(new Node(i, n.length + 1));
                }
            }
        }

        return -1;

    }
}

class Node{
    int data;
    int length;
    Node(int data,int length){
        this.data = data;
        this.length = length;
    }
}
