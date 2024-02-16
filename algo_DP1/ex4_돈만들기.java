package algo_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex4_돈만들기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(str1.nextToken()); // 동전의 수
        int n = Integer.parseInt(str1.nextToken()); // 만들 수 있는 금액
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        int[] arr = new int[x];
        for(int i=0; i<x; i++){
            arr[i] = Integer.parseInt(str2.nextToken());
        }
        int[] dp = new int[n+1];
        for(int j=0; j<x; j++){
            dp[arr[j]] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=0; j<x; j++){
                if(i-arr[j]>=0 && dp[i]!=0){
                    dp[i] = Math.min(dp[i], dp[i-arr[j]]);
                }else{
                    continue;
                }
            }
        }
        if(dp[n]==0){
            System.out.println(-1);
        }else{
            System.out.println(dp[n]);
        }
    }
}

// dp(n) = 1+ dp(n-1), 5+dp(n-5) 이런식으로 해서 최솟값 찾기