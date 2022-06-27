package BaekJoon11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

class Str{
    int x;
    int y;
    Str(int a,int b){
        x=a;
        y=b;
    }

    @Override
    public String toString() {
        return x+" "+y;
    }
}

class MyComparator implements Comparator<Str> {
    @Override
    public int compare(Str o1, Str o2) {
        if(o1.x>o2.x) return 1;
        else if(o1.x==o2.x){
            if(o1.y>o2.y) return 1;
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        Str[] strs = new Str[num];
        for(int i=0;i<num;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            strs[i] = new Str(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        MyComparator myComparator = new MyComparator();
        sort(strs,myComparator);
        for(int i=0;i<num;i++){
            System.out.println(strs[i]);
        }
    }
}

