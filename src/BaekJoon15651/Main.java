package BaekJoon15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static StringBuffer s2 = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String[] ss = s.split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
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
        for(int i=1;i<=n;i++){
            arr[a]=i;
            MakeSequence(n, m, a + 1);
        }
    }
}

