package algo_BFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_3차원 {
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int M, N, H;
    static int[][][] map;
    static int[][][] visited;
    static Queue<int[]> queue;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        H = Integer.parseInt(st.nextToken()); // 높이
        map = new int[H][N][M];
        visited = new int[H][N][M];
        queue = new LinkedList<>();
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        visited[i][j][k] = 1;
                        queue.add(new int[] {i, j, k});
                    }
                }
            }
        }
        bfs();

        int day = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(visited[i][j][k] == 0 && map[i][j][k] != -1){
                        System.out.print(-1);
                        return;
                    }
                    day = Math.max(day, visited[i][j][k]-1);
                }
            }
        }
        System.out.print(day);

    }
    static void bfs(){
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nwh = now[0]; int nwx = now[1]; int nwy = now[2];
            for(int i=0; i<6; i++){
                int nh = nwh + dz[i];
                int nx = nwx + dx[i];
                int ny = nwy + dy[i];
                if(nh<0 || nx<0 || ny<0 || nh>=H || nx>=N || ny>=M) continue;
                if(map[nh][nx][ny] == 0){
                    map[nh][nx][ny] = 1;
                    visited[nh][nx][ny] = visited[nwh][nwx][nwy] + 1;
                    queue.add(new int[] {nh, nx, ny});
                }
            }
        }
    }
}
