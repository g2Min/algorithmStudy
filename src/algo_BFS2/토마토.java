package algo_BFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    visited[i][j] = 1;
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

        int day = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] == 0 && map[i][j] != -1){
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, visited[i][j]-1);
            }
        }
        System.out.print(day);
    }
    static void bfs(){
        while(!queue.isEmpty()){
            int[] nw = queue.poll();
            int nwx = nw[0]; int nwy = nw[1];
            for(int i=0; i<4; i++){
                int nx = nwx + dx[i];
                int ny = nwy + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(map[nx][ny] == 0){
                    map[nx][ny] = 1;
                    visited[nx][ny] = visited[nwx][nwy] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}
