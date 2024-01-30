package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1_N과M3 {
    private static int N, M;
    private static int[] arr;
    private static StringBuilder ans = new StringBuilder();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[M];

       dfs(0);
       System.out.print(ans);

    }
    public static void dfs(int x){
        if(x == M){
            for(int i=0; i<M; i++){
                ans.append(arr[i]).append(' ');
            }
            ans.append('\n');
            return;
        }
        for(int i=1; i<=N; i++){
            arr[x] = i;
            dfs(x+1);
            arr[x] = 0;
        }
    }
}

// N과 M3
// 입력값: N M => 출력개수: N^M
// for(i~N) 이안에서 for(i~N)을 M만큼 => 재귀함수
