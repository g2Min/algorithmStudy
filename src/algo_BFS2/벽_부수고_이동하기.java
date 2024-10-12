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
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1]; // (1,1) ~ (N,M)
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                map[i+1][j+1] = input.charAt(j) - '0';
            }
        }
        int[][] dist = new int[N+1][M+1];
        dist[1][1] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1,1});
        int limit = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int x = now[0]; int y = now[1];
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<1 || nx>N || ny<1 || ny>M) continue;
            }
        }

    }
}
