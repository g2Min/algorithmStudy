package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 피보나치_함수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] ques = new int[T];
        int max = 0;
        for(int i=0; i<T; i++){
            ques[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, ques[i]);
        }
        int[][] dp = new int[Math.max(2, max+1)][2];
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;

        for(int i=2; i<=max; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = dp[i-1][j] + dp[i-2][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            sb.append(dp[ques[i]][0]).append(" ").append(dp[ques[i]][1]).append("\n");
        }
        System.out.print(sb);
    }
}
