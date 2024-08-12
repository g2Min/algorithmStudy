package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 멀리_뛰기 {
    static long M = 1234567;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 합산해서 N
        long ans = solution(N) % M;
        System.out.print(ans);
    }
    public static long solution(int n){
        long[] dp = new long[n+1]; // 1과 2 이하의 수의 합으로 이루어진 배열
        if(n == 1) return 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

/* 4 => 2 2 / 2 1 1 / 1 1 1 1  (1 + 3!/2! + 1) = 5
A % 2 => B (최대 몫) (2, 1) => (B, A-B), (B-1, A-2*(B-1)), ... (0, B)
* */