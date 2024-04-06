package algo_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
//        Arrays.sort(arr); // 오름차순 정렬
        int[] dp = new int[n+1];
        int MIN = Integer.MAX_VALUE; // 가장 작은 값을 저장할 변수

        for(int j=0; j<x; j++){ //동전의 종류들은 모두 최솟값을 가진다.
            dp[arr[j]]=1;
        }
        int j=0;
        for(int i=1; i<=n; i++){
            while(j<x){
                if(i-arr[j]>=0){
                    dp[i] = dp[i-arr[j]];
                }
            }
        }
    }
}

// dp(n) = 1+dp(n-1) || 5+dp(n-5) || dp(n-7) 이중에서 최솟값 찾기
// 모두 -1로 초기화해놓고 0인 index만 0으로 둬서 -1의