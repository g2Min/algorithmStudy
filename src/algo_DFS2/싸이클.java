package algo_DFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 싸이클 {
    static int N, P;
    static int[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        dfs(N, 1);
        System.out.print(ans);
    }
    static void dfs(int x, int round){
        if(visited[x] == 0){ // 아직 방문안한 경우
            visited[x] = round;
            dfs((x*N)%P, round+1);
        }else{
            ans = round - visited[x];
        }
    }
}
