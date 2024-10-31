package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단_오르기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N+1];
        for(int i=1; i<=N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[Math.max(4, N+1)];
        if(N==1){
            System.out.print(stairs[1]);
            return;
        }else if(N==2){
            System.out.print(stairs[1]+stairs[2]);
            return;
        }
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(dp[1]+stairs[3], stairs[2]+stairs[3]);
        for(int i=4; i<=N; i++){
            dp[i] = Math.max(dp[i-2]+stairs[i], dp[i-3]+stairs[i-1]+stairs[i]);
        }
        System.out.print(dp[N]);
    }
}
