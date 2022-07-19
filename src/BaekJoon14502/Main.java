package BaekJoon14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] list;
    static int max;
    static int n,m,initialSafe;
    static int[] RUD = {1, -1, 0, 0};
    static int[] CLR = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n + 2][m + 2];

        for(int i=0;i<n+2;i++){
            list[i][0] = 1;
            list[i][m + 1]=1;
        }
        for(int i=0;i<m+2;i++){
            list[0][i] = 1;
            list[n+1][i]=1;
        }
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<m+1;j++){
                int data = Integer.parseInt(st.nextToken());
                if(data==0) initialSafe++;
                list[i][j] = data;
            }
        }
        DFS(0);

        System.out.println(max);
    }

    static void DFS(int count){
        if(count==3){
            BFS();
            return;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(list[i][j]==1||list[i][j]==2) continue;
                list[i][j]=1;
                DFS(count+1);
                list[i][j]=0;
            }
        }
    }

    static void BFS(){
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> columnQ = new LinkedList<>();
        int safePlace=initialSafe-3;

        int[][] copyList = new int[n + 2][m + 2];
        for(int i=0;i<n+2;i++){
            copyList[i]=list[i].clone();
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++) {
                if (copyList[i][j] == 2) {
                    rowQ.add(i);
                    columnQ.add(j);
                    while (!rowQ.isEmpty()) {
                        int currentRow = rowQ.poll();
                        int currentColumn = columnQ.poll();
                        for (int k = 0; k < 4; k++) {
                            int newR = currentRow + RUD[k];
                            int newC = currentColumn + CLR[k];

                            if (copyList[newR][newC] == 0) {
                                rowQ.add(newR);
                                columnQ.add(newC);
                                copyList[newR][newC] = 2;
                                safePlace--;
                            }
                        }
                    }
                }
            }
        }
        if(max<safePlace) max=safePlace;
    }
}
