package algo_DFS1;

import java.util.*;
import java.io.*;

public class q1_N과M3_re{
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[M+1];
        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int x){
        if(x==M){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=1; i<=N; i++){
            arr[x] = i;
            dfs(x+1);
            arr[x] = 0;
        }
    }
}