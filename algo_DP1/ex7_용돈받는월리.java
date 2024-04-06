package algo_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex7_용돈받는월리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //월리가 일하는 날
        StringTokenizer str;
        int[][] dp = new int[N+1][3]; //dp[i][j] 라고 할때, i번째 날 j일을 할때 i-1번째 날은 j말고 나머지일을 하고 max를 구한다.

        for(int i=1; i<=N; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            int z = Integer.parseInt(str.nextToken());
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + x;
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + y;
            dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + z;
        }
        System.out.print(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
    }
}

// 한행당 하나는 반드시 선택 + 연속된 행에 연속된 열을 선택할 수 없음