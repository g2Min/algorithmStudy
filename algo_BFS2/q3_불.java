package algo_BFS2;

import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q3_불 {
    static int num;
    static int row, column;
    static char[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<int[]> wally, fire;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        num = Integer.parseInt(str1.nextToken()); // 테스트 케이스 개수
        StringTokenizer str2;
        for(int i=0; i<num; i++){
            str2 = new StringTokenizer(br.readLine());
            column = Integer.parseInt(str2.nextToken());
            row = Integer.parseInt(str2.nextToken());
            map = new char[row][column];
            wally = new LinkedList<>();
            fire = new LinkedList<>();
            for(int j=0; j<row; j++){
                String str3 = br.readLine();
                for(int k=0; k<column; k++){
                    map[j][k] = str3.charAt(k);
                    if(map[j][k] == '@'){ //윌리 위치
                        wally.add(new int[] {j, k, 0, row, column});
                    }
                    if(map[j][k] == '*'){ //불의 위치
                        fire.add(new int[] {j, k, row, column});
                    }
                }
            }
            int ans = -1;
            out: while(true){
                int fSize = fire.size();
                for(int l=0; l<fSize; l++){
                    int[] p = fire.poll();
                    fireMove(p[0], p[1], p[2], p[3]);
                }
                int wSize = wally.size();
                for(int m=0; m<wSize; m++){
                    int[] p = wally.poll();
                    ans = wallyMove(p[0], p[1], p[2], p[3], p[4]);
                    if(ans != -1) break out;
                }
                if(wally.isEmpty()) break;
            }
            if(ans == -1){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(ans);
            }
        }
    }
    public static int wallyMove(int x, int y, int time, int row, int column){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if( nx <0 || ny <0 || nx > row-1 || ny > column-1) {
                return time+1; // 탈출 성공
            }

            if( map[nx][ny] == '.'){
                map[nx][ny] = '@';
                wally.add(new int[] {nx, ny, time+1, row, column});
            }
        }
        return -1;
    }

    public static void fireMove(int x, int y, int row, int column){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if( nx <0 || ny <0 || nx > row-1 || ny > column-1 ) continue;
            if( map[nx][ny] == '.' || map[nx][ny] == '@'){
                map[nx][ny] = '*';
                fire.add(new int[] {nx, ny, row, column});
            }
        }
    }
}

// 열-행 으로 입력받음
// @로 시작해서 .근처로 간다음에 아예 빠져나갈때까지 계산
// *가 오는 시기도 생각해야 함 -> 시작점 여러곳