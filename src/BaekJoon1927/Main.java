package BaekJoon1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] list;
    static int size =0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        list = new int[num];

        for(int i=0;i<num;i++){
            int data = Integer.parseInt(br.readLine());
            if(data==0) deleteData();
            else addData(data);
        }
        System.out.println(sb);
    }


    static void deleteData(){
        if(size==0){
            sb.append(0).append("\n");
            return;
        }
        sb.append(list[1]).append("\n");
        int data = list[size--];
        int currentIndex = 1;
        int child = 2;
        while(child<=size){
            if(child<size&&list[child]>list[child+1]) child++;
            if(data<=list[child]) break;
            list[currentIndex] = list[child];
            currentIndex =child;
            child*=2;
        }
        list[currentIndex] =data;

    }
    static void addData(int data){
        int currentIndex = ++size;
        while (currentIndex != 1 && list[currentIndex / 2] > data) {
            list[currentIndex] = list[currentIndex / 2];
            currentIndex = currentIndex / 2;
        }
        list[currentIndex] = data;
    }
}
