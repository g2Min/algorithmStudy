package algo_DFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 둘레 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[102][102]; //(0,0) ~ (101, 101)
        visited = new boolean[102][102];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
        }

        dfs(0,0);
        for(int i=1; i<=100; i++){
            for(int j=1; j<=100; j++){
                if(arr[i][j] == 1){
                    for(int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(arr[nx][ny] == 0 && visited[nx][ny]) ans++;
                    }
                }
            }
        }
        System.out.print(ans);
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>101 || ny<0 ||ny>101) continue;
            if(!visited[nx][ny] && arr[nx][ny] == 0){
                dfs(nx, ny);
            }
        }
    }
}
