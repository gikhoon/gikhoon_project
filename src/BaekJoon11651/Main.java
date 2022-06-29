package BaekJoon11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pointer implements Comparable<Pointer>{
    private int x;
    private int y;
    Pointer(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Pointer o) {
        if(y>o.y) return 1;
        else if(y==o.y){
            if(x>o.x) return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return x+" "+y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        Pointer[] pointers = new Pointer[num];
        for(int i=0;i<num;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            pointers[i] = new Pointer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(pointers);

        for(int i=0;i<num;i++) System.out.println(pointers[i]);
    }

}
