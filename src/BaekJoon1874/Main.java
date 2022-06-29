package BaekJoon1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int[] wantedArray = new int[num];
        int wantedIndex =0;
        int inputStackNum =1;
        int cnt=0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<num;i++){
            wantedArray[i] = Integer.parseInt(br.readLine());
        }
        while(cnt<=2*num){
            if(wantedIndex==num) break;
            if(!s.isEmpty()){
                if(s.peek()==wantedArray[wantedIndex]){
                    s.pop();
                    wantedIndex++;
                    sb.append("-\n");
                }else{
                    s.push(inputStackNum++);
                    sb.append("+\n");
                }
            }else{
                s.push(inputStackNum++);
                sb.append("+\n");
            }
            cnt++;
        }
        if(cnt>2*num){
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
