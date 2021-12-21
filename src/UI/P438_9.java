package UI;

import java.util.*;

interface IStack<T>{
    T pop();
    boolean push(T ob);
}
class MyStack<T> implements IStack<T>{
    Vector<T> vector;
    int stack =0;
    public MyStack(){
        vector = new Vector<>();
    }
    public T pop(){
        if(stack==0)
            return null;
        T num = vector.get(stack-1);
        stack--;
        return num;
    }
    public boolean push(T ob){
        vector.add(ob);
        stack++;
        return true;
    }
}
public class P438_9 {
    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<>();
        for(int i=0;i<10;i++) stack.push(i);
        while(true){
            Integer n = stack.pop();
            if(n==null) break;
            System.out.print(n + " ");
        }
    }
}