package algo_시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q6_오목판단 {
    static char[][] map;
    static int[] dx = {1, 0, -1, 0}; // 오른쪽 옆(1,0), 아래(0,-1), 아래로 대각선(1|-1, -1)
    static int[] dy = {0, 1, 0, -1};
    static int[][][] memo = new int[7][7][4];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[8][8]; //입력받은 바둑판
        for(int i=1; i<8; i++){
            String lines = br.readLine();
            for(int j=1; j<8; j++){
                map[i][j] = lines.charAt(j);
            }
        }

        char ans = '.';
        for(int i=1; i<8; i++){
            for(int j=1; j<8; j++){
                for(int k=0; k<4; k++){
                    if(calc(i,j,k, map[i][j]) == 5 && memo[i][j][k] ==0){
                     ans = map[i][j];
                    }
                }
            }
        }

        System.out.print(ans);
    }
    private static int calc(int x, int y, int dir, char color){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if( nx<7 && ny<7 && map[nx][ny] == color ){
            return memo[nx][ny][dir] = calc(nx, ny, dir, color) + 1;
        }
        return 1;
    }


}


// 오목판담
// o win => o| x win => x| no winner => . 출력값
// 처음 발견하고 i) 옆으로가느냐 ii) 아래로 가느냐 iii) 대각선으로 가느냐
// 결국 대각선인 경우 두 좌푯값 차이의 절댓값이 모두 동일
