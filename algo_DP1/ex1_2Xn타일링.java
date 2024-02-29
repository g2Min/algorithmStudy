package algo_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1_2Xn타일링 {
    static int MAX = 10007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=N ; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MAX;
        }
        System.out.print(dp[N]);
    }
}
