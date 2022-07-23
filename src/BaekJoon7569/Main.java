package BaekJoon7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] RUD = {-1, 1, 0, 0, 0, 0};
    static int[] CLR = {0, 0, -1, 1, 0, 0};
    static int[] HHL = {0, 0, 0, 0, 1, -1};
    static int[][][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        list = new int[N + 2][M + 2][H + 2];

        for(int i=0;i<M+2;i++){
            for(int j=0;j<N+2;j++){
                list[j][i][0]=-1;
                list[j][i][H+1]=-1;
            }
        }
        for(int i=0;i<H+2;i++){
            for(int j=0;j<N+2;j++){
                list[j][0][i]=-1;
                list[j][M+1][i]=-1;
            }
        }
        for(int i=0;i<M+2;i++){
            for(int j=0;j<H+2;j++){
                list[0][i][j]=-1;
                list[N+1][i][j]=-1;
            }
        }

        Queue<Node> q = new LinkedList<>();
        for(int h=1;h<H+1;h++) {
            for (int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < M + 1; j++) {
                    list[i][j][h] = Integer.parseInt(st.nextToken());
                    if (list[i][j][h] == 1) q.add(new Node(i, j, h, 0));
                }
            }
        }
        Node lastNode = null;
        while (!q.isEmpty()) {
            lastNode = q.poll();
            int x = lastNode.x;
            int y = lastNode.y;
            int h = lastNode.h;

            for(int i=0;i<6;i++){
                if(list[x+RUD[i]][y+CLR[i]][h+HHL[i]]==0){
                    q.add(new Node(x + RUD[i], y + CLR[i],h+HHL[i], lastNode.days + 1));
                    list[x+RUD[i]][y+CLR[i]][h+HHL[i]]=1;
                }
            }
        }
        boolean zeroExist=false;
        All:for(int h=1;h<H+1;h++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < M + 1; j++) {
                    if (list[i][j][h] == 0) {
                        zeroExist = true;
                        break All;
                    }
                }
            }
        }
        if(zeroExist) System.out.println(-1);
        else if(lastNode!=null) System.out.println(lastNode.days);
        else System.out.println(0);


    }
}
class Node{
    int x;
    int y;
    int h;
    int days;
    Node(int x,int y, int h,int days){
        this.x=x;
        this.y=y;
        this.h=h;
        this.days=days;
    }
}
