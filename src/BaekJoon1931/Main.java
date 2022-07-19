package BaekJoon1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;
    Meeting(int start,int end){
        this.start=start;
        this.end=end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(end<o.end) return -1;
        else if(end>o.end) return 1;
        else{
            return Integer.compare(start, o.start);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Meeting[] schedule = new Meeting[num];

        for(int i=0;i<num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(schedule);
        int count=0;
        int canCountTime=-1;

        for(int i=0;i<num;i++){
            if(schedule[i].start>=canCountTime){
                count++;
                canCountTime=schedule[i].end;
            }
        }
        System.out.println(count);
    }
}
