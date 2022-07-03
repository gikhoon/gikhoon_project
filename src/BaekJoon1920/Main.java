package BaekJoon1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [] list;
    static StringBuilder sb = new StringBuilder();

    static int FindToken(int low,int high, int data){
        int middle;
        while (low<=high) {
            middle = (low + high) / 2;

            if(list[middle]>data) high=middle-1;
            else if(list[middle]<data) low=middle+1;
            else{
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());
        list = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<num;i++) list[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<num;i++){
            sb.append(FindToken(0,list.length-1,Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.println(sb);
    }

}
