package BaekJoon1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Print{
    private int index;
    private int weight;
    Print(int a, int b){
        index=a;
        weight=b;
    }
    int getWeight(){
        return weight;
    }
    int getIndex(){
        return index;
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        for(int i=0;i<num;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int indexCount = Integer.parseInt(st.nextToken());
            int wantedIndex = Integer.parseInt(st.nextToken());
            Queue<Print> q = new LinkedList<>();

            int cnt=0;
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<indexCount;j++) {
                q.offer(new Print(j,Integer.parseInt(st.nextToken())));
            }

            while(!q.isEmpty()){
                Print currentPrint = q.poll();
                int data = currentPrint.getWeight();
                boolean flag = true;
                for(Print p:q){
                    if(data<p.getWeight()){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    cnt++;
                    if(currentPrint.getIndex()==wantedIndex) break;
                }else{
                    q.offer(currentPrint);
                }
            }
            System.out.println(cnt);
        }
    }
}
