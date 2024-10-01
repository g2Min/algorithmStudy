package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모든_순열 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n+1];
        dfs(0);
        System.out.print(sb);
    }
    static void dfs(int x){
        if(x == n){
            for(int i=0; i<n; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                arr[x] = i;
                visited[i] = true;
                dfs(x+1);
                arr[x] = 0;
                visited[i] = false;
            }
        }
    }
}
