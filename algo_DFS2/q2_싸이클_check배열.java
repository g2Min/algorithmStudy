package algo_DFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2_싸이클_check배열 {
    private static int N, P, ans;
    private static int[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        P = Integer.parseInt(str.nextToken());
        visited = new int[1001]; //임의로 잡아놓고 시작
        dfs(N, 0);
        System.out.println(ans);
    }
    public static void dfs(int x, int round){
        if(visited[x] == 0){
            visited[x] = round;
            dfs((x*N)%P, round+1);
        }else{
            ans = round - visited[x];
        }
    }
}
