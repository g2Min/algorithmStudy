package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3_모든순열 {
    private static int N;
    private static int[] arr;
    private static StringBuilder ans = new StringBuilder();
    private static boolean[] used;
    public  static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        arr = new int[N+1];
        used = new boolean[N+1];

        dfs(0);
        System.out.print(ans);
    }
    public static void dfs(int x){
        if(x == N){
            for(int i=0; i<N; i++){
                ans.append(arr[i]).append(' ');
            }
            ans.append('\n');
            return;
        }

        for(int i=1; i<=N; i++){
            if(used[i] == true) {
                continue;
            }
            arr[x] = i;
            used[i] = true;
            dfs(x+1);
            arr[x] = 0;
            used[i] = false;
        }
    }
}

// 모든 순열
// 얜 그 다음의 index에 대해서도 알고리즘이 필요하다.
