package BaekJoon1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
    static boolean [][] array;
    static boolean [][] isVisited;
    static int [][] cabbages;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for(int count=0;count<num;count++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());

            array = new boolean[n + 2][m + 2];
            isVisited = new boolean[n+2][m+2];
            cabbages = new int[cabbage][2];


            for(int i=0;i<cabbage;i++){
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                cabbages[i][0]=col+1;
                cabbages[i][1]=row+1;
                array[col+1][row+1]=true;
            }
            int countBug = 0;
            for(int i=0;i<cabbage;i++){
                if(BFS(cabbages[i][0],cabbages[i][1])) countBug++;
            }
            sb.append(countBug).append("\n");
        }
        System.out.println(sb);
    }

    static boolean BFS(int x,int y){
        int[] UD = {0, 0, -1, 1};
        int[] LR = {1, -1, 0, 0};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(x);
        qy.add(y);
        if(isVisited[x][y]){
            return false;
        }
        isVisited[x][y]=true;
        while(!qx.isEmpty()){
            x=qx.poll();
            y=qy.poll();
            for(int i=0;i<4;i++){
                if(!isVisited[x+LR[i]][y+UD[i]]&&array[x+LR[i]][y+UD[i]]){
                    qx.add(x + LR[i]);
                    qy.add(y + UD[i]);
                    isVisited[x+LR[i]][y+UD[i]]=true;
                }
            }

        }
        return true;
    }
}
