package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐험 {
    static int[][] dist, map;
    static Queue<int[]> q;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1][M+1];
        map = new int[N+1][M+1];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                map[i+1][j+1] = input.charAt(j) - '0';
            }
        }
        dist[1][1] = 1;
        q = new LinkedList<>();
        q.offer(new int[] {1, 1});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int x = now[0], y=now[1];
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<1 || nx>N || ny<1 || ny>M) continue;
                if(dist[nx][ny] == 0 && map[nx][ny] == 1){
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        if(dist[N][M] == 0) System.out.print(-1);
        else  System.out.print(dist[N][M]);

    }
}
