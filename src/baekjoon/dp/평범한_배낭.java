package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

class Bag{
    int w, v;
    Bag(int w, int v){
        this.w = w;
        this.v = v;
    }
}
public class 평범한_배낭 {
    static int N, K;
    static Bag[] bags;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bags = new Bag[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bags[i] = new Bag(a, b);
        }
        int[][] dp = new int[N+1][K+1];
        for(int i=1; i<=N; i++){
            for(int w=0; w<=K; w++){
                if(w >= bags[i].w){
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-bags[i].w] + bags[i].v);
                }else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        System.out.print(dp[N][K]);
    }
}
