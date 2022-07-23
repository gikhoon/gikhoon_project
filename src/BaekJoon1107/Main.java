package BaekJoon1107;

import java.util.*;

public class Main {
    static int result;
    static int N;
    static int[] array;
    static int answer = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        result = sc.nextInt();
        N = sc.nextInt();
        array = new int[10];
        for (int i = 0; i < N; i++) {
            array[sc.nextInt()] = 1;
        }

        for (int i = 0; i <= 9; i++) {
            if (array[i] == 0) list.add(i);
        }

        answer = Math.abs(result - 100);

        if (array[0] != 1) {
            answer = Math.min(answer, result + 1);
        }

        for (int i = 1; i <= 1000000; i++) {
            if (isContain(i)) continue;

            int val = Integer.toString(i).length() + Math.abs(i - result);
            if (val < answer) answer = val;
        }

        System.out.println(answer);
    }

    public static boolean isContain(int N) {
        while (N != 0) {
            if (!list.contains(N % 10)) return true;
            N = N / 10;
        }

        return false;
    }
}



