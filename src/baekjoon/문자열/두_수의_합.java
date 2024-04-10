package baekjoon.문자열;

import java.io.*;
import java.util.*;

public class 두_수의_합{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        int cnt = 0;
        // 1 2 3 4 5
        // 1 2 3 4
        boolean[] exist = new boolean[10000001];
        for(int i=0; i<N; i++){
            exist[arr[i]] = true;
        }

        for(int i=0; i<N; i++){
            int pairValue = x - arr[i];
            if(0<=pairValue && pairValue<=1000000)
                cnt += exist[pairValue] ? 1:0;
        }
        System.out.println(cnt/2);

    }
}
