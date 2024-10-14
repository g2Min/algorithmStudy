package algo_BFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐험 {
    static int[][] map;
    static int row, column;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        row = Integer.parseInt(str1.nextToken()); // 행
        column = Integer.parseInt(str1.nextToken()); // 열

        map = new int[row][column]; // 입력받을 숫자들
        for(int i=0; i<row; i++){
            String str2 = br.readLine();
            for(int j=0; j<column; j++){
                map[i][j] = str2.charAt(j) - '0';
            }
        }
        visited = new boolean[row][column];
        visited[0][0] = true;
        bfs(0, 0);

        if(map[row-1][column-1] == 1) {
            System.out.println("-1");
        }else{
            System.out.println(map[row-1][column-1]);
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowx = now[0];
            int nowy = now[1];

            for(int i=0; i<4; i++){
                int nextX = nowx + dx[i];
                int nextY = nowy + dy[i];
                if(nextX <0 || nextY <0 || nextX >=row || nextY >=column) continue;
                if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

                queue.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[nowx][nowy] + 1;
                visited[nextX][nextY] = true;
            }

        }
    }
}
