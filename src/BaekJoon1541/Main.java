package BaekJoon1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"+-",true);

        Stack<String> s = new Stack<>();
        int sum=0;

        while(st.hasMoreTokens()){
            String nt = st.nextToken();
            if(nt.equals("-")){
                int subSum=0;
                while(!s.isEmpty()){
                    String popStack = s.pop();
                    if(popStack.equals("-")){
                        subSum=-subSum;
                        break;
                    }else{
                        subSum += Integer.parseInt(popStack);
                    }
                }
                sum+=subSum;
                s.add(nt);
            }else if(!nt.equals("+")) s.add(nt);
        }
        int subSum=0;
        while(!s.isEmpty()){
            String popStack = s.pop();
            if(popStack.equals("-")){
                subSum=-subSum;
                break;
            }else{
                subSum += Integer.parseInt(popStack);
            }
        }
        sum+=subSum;
        System.out.println(sum);
    }
}
