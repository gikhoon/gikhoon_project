package BaekJoon9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int N;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        NQueen(0);
        System.out.println(count);
    }

    static void NQueen(int deep){
        if(deep==N){
            count++;
            return;
        }
        for(int i=0;i<N;i++){
            arr[deep] = i;
            if(!isOverlap(deep)){
                NQueen(deep+1);
            }
        }
    }
    static boolean isOverlap(int deep){
        for(int i=0;i<deep;i++){
            if(arr[i]==arr[deep]) return true;
            else if(Math.abs(arr[i]-arr[deep])==Math.abs(i-deep)) return true;
        }
        return false;
    }

}

