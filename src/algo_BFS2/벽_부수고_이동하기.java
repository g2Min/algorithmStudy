package algo_BFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] map;
    static int[][][] dist;
    static boolean[][][] visited;
    static int N, M;
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1]; // (1,1) ~ (N,M)
        dist = new int[N+1][M+1][2];
        visited = new boolean[N+1][M+1][2];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                map[i+1][j+1] = input.charAt(j) - '0';
            }
        }
        dist[1][1][0] = 1;
        queue.add(new int[] {1, 1, 0}); //시작점, 벽 안부숨,
        bfs();

        int result = -1;
        if (dist[N][M][0] != 0 && dist[N][M][1] != 0) {
            result = Math.min(dist[N][M][0], dist[N][M][1]);
        } else if (dist[N][M][0] != 0) {
            result = dist[N][M][0];
        } else if (dist[N][M][1] != 0) {
            result = dist[N][M][1];
        }

        System.out.println(result);
    }
    static void bfs(){
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0]; int y = now[1]; int wallBroken = now[2];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<1 || ny<1 || nx>N || ny>M) continue;
                if(map[nx][ny] == 0 && dist[nx][ny][wallBroken] == 0){
                    dist[nx][ny][wallBroken] = dist[x][y][wallBroken] + 1;
                    queue.add(new int[]{nx, ny, wallBroken});
                }
                if(map[nx][ny] == 1 && dist[nx][ny][1] == 0 && wallBroken == 0){
                    dist[nx][ny][1] = dist[x][y][wallBroken] + 1;
                    queue.offer(new int[] {nx, ny, 1});
                }
            }
        }
    }
}
