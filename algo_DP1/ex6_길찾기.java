package algo_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex6_길찾기 {
    static int MAX = (int) Math.pow(10,9) + 7;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 가로, 세로 길이 N
        char[][] arr = new char[N+1][N+1];
        for(int i=1; i<=N; i++){
            String line = br.readLine();
            for(int j=1; j<=N; j++){
                arr[i][j] = line.charAt(j-1);
            }
        }
        int[][] dp = new int[N+1][N+1];
        dp[0][1] = 1;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(arr[i][j] == '*') continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MAX;
            }
        }
        System.out.println(dp[N][N]);
    }
}

// 수학문제에서 출제되는 최단 경로 문항에서 오른쪽 아래로 가는 경로수는 왼쪽 + 위쪽 이런 식의 점화식을 만들면 될 것