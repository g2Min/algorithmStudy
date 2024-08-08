package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 단지번호붙이기 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int N, cnt;
    private static ArrayList<Integer> ans;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        ans = new ArrayList<>();
        cnt = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    dfs(i, j);
                    ans.add(cnt);
                    cnt = 1;
                }
            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx <N && ny <N){
                if(!visited[nx][ny] && map[nx][ny]==1){
                    cnt++;
                    dfs(nx, ny);
                }
            }
        }
    }
}
