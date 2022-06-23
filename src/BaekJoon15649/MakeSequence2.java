package BaekJoon15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeSequence2 {
    static int[] arr;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String[] ss = s.split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        arr = new int[m];
        isVisited = new boolean[n];
        MakeSequence(n,m,0);
    }
    static void MakeSequence(int n,int m,int a){
        if(a==m){
            for(int i=0;i<m-1;i++) System.out.print(arr[i]+" ");
            System.out.println(arr[m-1]);
            return;
        }
        for(int i=1;i<=n;i++){
            if(isVisited[i-1]) continue;
            arr[a]=i;
            isVisited[i-1]=true;
            MakeSequence(n, m, a + 1);
            isVisited[i-1]=false;
        }
    }
}

