package BaekJoon1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        while(N!=0){
            int x=r/(int)Math.pow(2,N-1);
            int y=c/(int)Math.pow(2,N-1);
            if(x==1&&y==1) sum+=3*Math.pow(2,2*N-2);
            else if(x==1&&y==0) sum+=2*Math.pow(2,2*N-2);
            else if(x==0&&y==1) sum+=Math.pow(2,2*N-2);
            r%=Math.pow(2,N-1);
            c%=Math.pow(2,N-1);
            N--;
        }
        System.out.println(sum);
    }
}
