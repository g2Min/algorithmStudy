package algo_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex3_수의분할 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str1.nextToken()); // 표현할 수의 개수
        int x = Integer.parseInt(str1.nextToken()); // 표현할 수
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        int[] arr = new int[n]; // dp 배열에 들어갈 숫자들
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str2.nextToken());
        }
        int MAX = (int) Math.pow(10,9) + 7;
        int[] dp = new int[x+1];
        dp[0] = 1;
        for(int i=1; i<=x; i++){
            for(int j=0; j<n; j++){
                if(i-arr[j] >= 0) dp[i] = (dp[i] + dp[i-arr[j]]) % MAX;
            }
        }
        System.out.println(dp[x]);
    }
}

// 9/2=4 + 9/3=3 + 9/5=1 = 8
// 각 수들로 구한 몫들의 합을