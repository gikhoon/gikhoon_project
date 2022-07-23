package BaekJoon5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cases = Integer.parseInt(br.readLine());

        All:for(int ca=0;ca<cases;ca++){
            sb = new StringBuilder();
            String command = br.readLine();
            int listCount = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            Deque<Integer> dq = new LinkedList<>();
            boolean startFirst = false;

            for(int i=0;i<listCount;i++){
                dq.addFirst(Integer.parseInt(st.nextToken()));
            }

            for(int i=0;i<command.length();i++){
                char cm = command.charAt(i);
                if(cm=='R'){
                    startFirst=!startFirst;
                }else{
                    if(listCount==0){
                        System.out.println("error");
                        continue All;
                    }
                    if(startFirst) dq.pollFirst();
                    else dq.pollLast();
                    listCount--;
                }
            }
            if(startFirst){
                sb.append("[");
                for(int i=0;i<listCount;i++){
                    sb.append(dq.pollFirst());
                    if(i!=listCount-1) sb.append(",");
                }
                sb.append("]");
                sb.append("\n");
            }
            else{
                sb.append("[");
                for(int i=0;i<listCount;i++){
                    sb.append(dq.pollLast());
                    if(i!=listCount-1) sb.append(",");
                }
                sb.append("]");
                sb.append("\n");
            }

            System.out.print(sb);
        }
    }
}
