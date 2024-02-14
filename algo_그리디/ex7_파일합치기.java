package algo_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex7_파일합치기 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) pq.add(Integer.parseInt(br.readLine()));
        int sum = 0;
        for(int i=1; i<N; i++){
            int x = pq.poll() + pq.poll();
            pq.add(x);
            sum +=x;
        }
        System.out.print(sum);
    }
}

// 4=> 10 20 30 40 => 10+20 + (30+30) + (60+40) = 30 + 60 + 100 = 190
// 5=> 10 20 30 40 50 => 10+20 +(30+30) + (60+40) + (100+50) = 190 + 150 = 340
// 30 40 50 60 => 30 60 40 50 => 90 + 90 + 180 = 360
// 매순간 가장 작은 두개를 합치는것
