package BaekJoon10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String[][] list;
    static int size;
    static boolean[][] isVisited;
    static int[] RUD = {-1,1,0,0};
    static int[] CLR = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        list = new String[size + 2][size + 2];
        isVisited = new boolean[size + 2][size + 2];

        for(int i=0;i<size+2;i++){
            list[0][i] = "N";
            list[size + 1][i] = "N";
            list[i][0] = "N";
            list[i][size + 1] = "N";
        }

        for(int i=1;i<size+1;i++){
            String s = br.readLine();
            for(int j=0;j<size;j++){
                list[i][j+1] = String.valueOf(s.charAt(j));
            }
        }

        int count1 = countZone();

        isVisited = new boolean[size + 2][size + 2];
        for(int i=1;i<size+1;i++){
            for(int j=1;j<size+1;j++){
                if(list[i][j].equals("G")) list[i][j]="R";
            }
        }

        int count2 = countZone();

        System.out.println(count1+" "+count2);
    }
    static int countZone(){
        int count=0;

        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        int currentRow;
        int currentColumn;

        for(int i=1;i<size+1;i++){
            for(int j=1;j<size+1;j++){
                if(isVisited[i][j]) continue;
                row.add(i);
                column.add(j);
                if(i==1&&j==1) isVisited[1][1]=true;
                while(!row.isEmpty()){
                    currentRow=row.poll();
                    currentColumn=column.poll();

                    for(int k=0;k<4;k++){
                        if (!isVisited[currentRow + RUD[k]][currentColumn + CLR[k]]&&list[currentRow][currentColumn].equals(list[currentRow + RUD[k]][currentColumn + CLR[k]])) {

                            isVisited[currentRow + RUD[k]][currentColumn + CLR[k]] = true;
                            row.add(currentRow + RUD[k]);
                            column.add(currentColumn + CLR[k]);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
