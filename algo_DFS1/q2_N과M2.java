package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2_N과M2 {
    private static int N,M;
    private static int[] arr;
    private static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[M]; // 한줄에 들어가는 원소개수

        dfs(0);
        System.out.print(ans);
    }
    public static void dfs(int x){
        if(x == M){
            for(int j=0; j<M; j++){
                ans.append(arr[j]).append(' ');
            }
            ans.append('\n');
            return;
        }

        if(x>=1){
            for(int i=arr[x-1]+1; i<=N; i++){
                arr[x] = i;
                dfs(x+1);
                arr[x] = 0;
            }
        }else{
            for(int i=1; i<=N; i++){
                arr[x] = i;
                dfs(x+1);
                arr[x] = 0;
            }
        }
    }
}

// N과 M2
// N과 M3와 다른 점은 중복이 없다는 것