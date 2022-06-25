package BaekJoon10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(sb.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<num;i++){
            String command = sb.readLine();
            StringTokenizer commands = new StringTokenizer(command);
            switch(commands.nextToken()){
                case "push":
                    int putNum = Integer.parseInt(commands.nextToken());
                    stack.push(putNum);
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        System.out.println("-1");
                    }else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        System.out.println("1");
                    } else{
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if(stack.isEmpty()) {
                        System.out.println("-1");
                    }else{
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
    }
}
