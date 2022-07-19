package BaekJoon1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
    int data;
    int seconds;
    Node(int data, int second){
        this.data=data;
        seconds = second;
    }
}
public class Main {
    static boolean[] isVisited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        isVisited[N]= true;
        Node currentNode;
        if(N==K){
            System.out.println(0);
            return;
        }
        while(true){
            currentNode =q.poll();
            int data= currentNode.data;
            int second = currentNode.seconds;
            if(data-1==K||data+1==K||data*2==K){
                System.out.println(second+1);
                break;
            }
            if(data-1>=0&&!isVisited[data-1]){
                q.add(new Node(data - 1, second + 1));
                isVisited[data - 1] = true;
            }
            if(data+1<=100000&&!isVisited[data+1]){
                q.add(new Node(data + 1, second + 1));
                isVisited[data + 1] = true;
            }
            if(data*2<=100000&&!isVisited[data*2]){
                q.add(new Node(data*2, second + 1));
                isVisited[data*2] = true;
            }
        }
    }
}
