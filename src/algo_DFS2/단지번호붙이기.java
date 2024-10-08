package algo_DFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int cnt;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int round = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                    round++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(round);
        for(int key: list){
            System.out.println(key);
        }
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        cnt++;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && arr[nx][ny]==1){
                dfs(nx, ny);
            }
        }
    }
}
