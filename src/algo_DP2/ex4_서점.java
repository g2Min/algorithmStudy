package algo_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex4_서점 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str, str1, str2;
        str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); //책의 개수
        int x = Integer.parseInt(str.nextToken()); //월리가 가진 돈

        long[][] dp = new long[N+1][x+1];

        str1 = new StringTokenizer(br.readLine());
        str2 = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int pi = Integer.parseInt(str1.nextToken()); // 각 책의 가격
            int si = Integer.parseInt(str2.nextToken()); // 각 책의 페이지 수
            for(int j=1; j<=x; j++){
                dp[i][j] = dp[i-1][j]; //i번째까지 최대 페이지수
                if(j-pi>=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-pi]+si);
                }
            }
        }
        System.out.println(dp[N][x]);
    }
}

// x원 이내로 구매한 책들의 페이지수의 합이 최대가 되도록