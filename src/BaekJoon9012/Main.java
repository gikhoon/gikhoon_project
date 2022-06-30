package BaekJoon9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        first: for(int i=0;i<num;i++){
            Stack<Boolean> stack = new Stack<>();
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='(') stack.push(true);
                else {
                    if(stack.isEmpty()){
                        sb.append("NO\n");
                        continue first;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);

    }
}
