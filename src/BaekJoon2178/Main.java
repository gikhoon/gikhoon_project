package BaekJoon2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;



public class Main {
    static int[] getDirection(String str){
        int[] a = new int[2];
        switch (str) {
            case "Right":
                a[0] = 1;
                break;
            case "Left":
                a[0] = -1;
                break;
            case "UP":
                a[1] = -1;
                break;
            case "Down":
                a[1] = 1;
                break;
        }
        return a;
    }
    static int[] backDirection(String str){
        int[] a = new int[2];
        switch (str) {
            case "Right":
                a[0] = -1;
                break;
            case "Left":
                a[0] = 1;
                break;
            case "UP":
                a[1] = 1;
                break;
            case "Down":
                a[1] = -1;
                break;
        }
        return a;
    }
    static boolean[][] maze;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        maze = new boolean[n + 2][m + 2];
        boolean [][] isVisited = new boolean[n + 2][m + 2];

        for(int i=1;i<=n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                if(str.charAt(j)=='1') maze[i][j+1]=true;
            }
        }


        final String [] direction = {"Right", "Down","Left", "UP"};

        int count=1;
        int currentRow=1; int currentColumn=1;
        Stack<String> history = new Stack<>();
        while(true){
            isVisited[currentRow][currentColumn]=true;
            boolean isChanged = false;
            for(int i=0;i<4;i++){
                int[] goDirection = getDirection(direction[i]);
                if(!isVisited[currentRow+goDirection[1]][currentColumn+goDirection[0]]
                        &&maze[currentRow+goDirection[1]][currentColumn+goDirection[0]]){
                    history.push(direction[i]);
                    currentRow+=goDirection[1];
                    currentColumn += goDirection[0];
                    isChanged=true;
                    count++;
                    break;
                }
            }
            if(!isChanged){
                String str = history.pop();
                int[] backDirection = backDirection(str);
                currentRow+=backDirection[1];
                currentColumn += backDirection[0];
                count--;
            }

            if(currentRow==n && currentColumn==m){
                System.out.println(count);
                break;
            }

        }
    }
}
