package BaekJoon15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static StringBuffer s2 = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer ss = new StringTokenizer(s);
        int n = Integer.parseInt(ss.nextToken());
        int m = Integer.parseInt(ss.nextToken());
        arr = new int[m];
        MakeSequence(n,m,0);
        System.out.println(s2);
    }

    static void MakeSequence(int n,int m,int a){
        if(a==m){
            for(int i=0;i<m-1;i++){
                s2.append(arr[i]).append(" ");
            }
            s2.append(arr[m-1]).append("\n");
            return;
        }
        label: for(int i=1;i<=n;i++){
            for(int j=0;j<a;j++){
                if(arr[j]>i) continue label;
            }
            arr[a]=i;
            MakeSequence(n, m, a + 1);
        }
    }
}

