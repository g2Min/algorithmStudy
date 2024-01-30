package algo_DFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1_NQueen_백트래킹방법 {
    private static int N, ans;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken()); // NxN 체스판에서 N
        arr = new int[N+1];

        dfs(1);
        System.out.println(ans);
    }
    public static void dfs(int x){
        if( x == N+1){
            ans ++;
            return;
        }
        for(int i=1; i<=N; i++){
            boolean pos =true;
            for(int j=1; j<x; j++){
                if( i == arr[j] || j - arr[j] == x-i || j + arr[j] == x+i){
                    pos = false;
                }
            }
            if(pos){
                arr[x] = i;
                dfs(x+1);
                arr[x] = 0;
            }
        }

    }
}

// N-Queen: NxN 체스판에서 각 퀸들은 상하좌우,대각선방향에 있으면 안된다.
// 1) 상하