package algo_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex2_욕심많은월리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // 물건 개수
        int W = Integer.parseInt(str.nextToken()); // 물건이 들어갈 수 있는 무게의 한계
        long[][] dp = new long[N+1][W+1];
        for(int i=1; i<=N; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken()); // 물건 무게
            int v = Integer.parseInt(str.nextToken()); // 물건 가치
            for(int j=1; j<=W; j++){
                dp[i][j] = dp[i-1][j];
                // dp로 원하는 무게까지 증가한다고 할때 만약 현 물건의 무게값이 j보다 작거나 같을떄
                if(j-x>=0){
                    //새로 정의되는 i번째 j무게 가치는 아래 1) 2)의 최댓값
                    // 1) 전승됨 2) 이전까지의 무게에서 현재 무게의 가치
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-x]+v);
                }
            }
        }
        System.out.print(dp[N][W]);
    }
}

//W보다 작거나 같게 담되 그 가치는 최대가 되게끔