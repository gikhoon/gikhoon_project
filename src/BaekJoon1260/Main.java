package BaekJoon1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean [][] table;
    static int vertex, edge,startingVertex ;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startingVertex = Integer.parseInt(st.nextToken());
        table = new boolean[vertex][vertex];
        for(int i=0;i<edge;i++){
            s=bf.readLine();
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            table[a-1][b-1]=true;
            table[b-1][a-1]=true;
        }
        DFS();
        BFS();
    }
    static void DFS(){
        boolean [] isVisited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        int currentVertex = startingVertex;
        stack.push(currentVertex);
        StringBuilder sb = new StringBuilder();
        boolean haveVertex;
        while(true){
            if(stack.isEmpty()){
                System.out.println(sb.toString().trim());
                break;
            }
            if(!isVisited[currentVertex-1]) sb.append(currentVertex).append(" ");
            isVisited[currentVertex-1]=true;
            haveVertex = false;
            for(int i=0;i<vertex;i++){
                if(!isVisited[i]&&table[currentVertex-1][i]){
                    haveVertex=true;
                    stack.push(i+1);
                    currentVertex = i+1;
                    break;
                }
            }
            if(!haveVertex){
                stack.pop();
                if(stack.isEmpty()) continue;
                currentVertex = stack.peek();
            }

        }
    }
    static void BFS(){
        boolean [] isVisited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        int currentVertex = startingVertex;
        queue.offer(currentVertex);
        isVisited[currentVertex-1]=true;
        StringBuilder sb = new StringBuilder();
        while(true){
            if(queue.isEmpty()) {
                System.out.println(sb.toString().trim());
                break;
            }
            currentVertex = queue.peek();
            sb.append(currentVertex).append(" ");
            for(int i=0;i<vertex;i++){
                if(!isVisited[i]&&table[currentVertex-1][i]){
                    isVisited[i]=true;
                    queue.offer(i+1);
                }
            }
            queue.poll();
        }
    }
}
