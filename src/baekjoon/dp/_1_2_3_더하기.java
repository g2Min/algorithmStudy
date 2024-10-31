package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_2_3_더하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] ques = new int[T];
        int max = 0;
        for(int i=0; i<T; i++){
            ques[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, ques[i]);
        }
        int[] dp = new int[Math.max(3, max+1)];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=max; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for(int i=0; i<T; i++){
            System.out.println(dp[ques[i]]);
        }
    }
}
