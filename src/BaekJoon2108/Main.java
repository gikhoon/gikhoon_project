package BaekJoon2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int [] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        double avg = (double)Arrays.stream(array).sum() / num;
        if(avg<0){
             sb.append((int)Math.round(Math.abs(avg)*-1)).append("\n");
        } else sb.append((int) Math.round(avg)).append("\n");

        sb.append(array[num / 2]).append("\n");

        int currentCount = 1;
        int mostIndex = 0;
        int mostCount = 1;
        boolean secondFound = false;
        for(int i=1;i<num;i++){
            if(array[i]==array[i-1]){
                currentCount++;
            }
            else{
                currentCount=1;
            }
            if(currentCount==mostCount){
                if(!secondFound){
                    secondFound=true;
                    mostIndex=i;
                }
            }else if(currentCount>mostCount){
                mostCount = currentCount;
                mostIndex=i;
                secondFound=false;
            }
        }
        sb.append(array[mostIndex]).append("\n");
        sb.append(array[num - 1] - array[0]);
        System.out.println(sb);
    }
}
