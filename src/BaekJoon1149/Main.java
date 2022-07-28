package BaekJoon1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] list;
    static int[][] sum;

    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        list = new int[num][3];
        sum = new int[num][3];



        for(int i=0;i<num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i][2] = Integer.parseInt(st.nextToken());
        }

        sum[num - 1][0] = list[num - 1][0];
        sum[num - 1][1] = list[num - 1][1];
        sum[num - 1][2] = list[num - 1][2];
        for(int i=num-2;i>=0;i--){
            sum[i][0] = list[i][0] + Math.min(sum[i + 1][1], sum[i + 1][2]);
            sum[i][1] = list[i][1] + Math.min(sum[i + 1][0], sum[i + 1][2]);
            sum[i][2] = list[i][2] + Math.min(sum[i + 1][0], sum[i + 1][1]);
        }
        System.out.println(Math.min(sum[0][0], Math.min(sum[0][1], sum[0][2])));

    }
}
