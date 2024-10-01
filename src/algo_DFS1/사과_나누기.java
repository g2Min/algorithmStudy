package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과_나누기 {
    static long ans = Long.MAX_VALUE;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.print(ans);
    }
    static void dfs(int x, long diff){
        if(x == N){
            if(Math.abs(diff) < ans){
                ans = Math.abs(diff);
            }
            return;
        }

        dfs(x+1, diff + arr[x]);
        dfs(x+1, diff - arr[x]);
    }
}
