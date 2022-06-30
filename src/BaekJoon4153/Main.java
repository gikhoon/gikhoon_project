package BaekJoon4153;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] length = new int[3];
            for(int i=0;i<3;i++) length[i]=Integer.parseInt(st.nextToken());
            if(length[0]==0&&length[1]==0&&length[2]==0) break;
            Arrays.sort(length);
            if(length[0]+length[1]>length[2]&&(Math.pow(length[0],2)+Math.pow(length[1],2)==Math.pow(length[2],2)))
                sb.append("right\n");
            else{
                sb.append("wrong\n");
            }
        }
        System.out.println(sb);
    }
}
