package algo_DFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class q3_단지번호붙이기 {
    private static int N, cnt;
    private static int[][] arr;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = { 0, 1, 0, -1};
    private static boolean[][] visited;
    private static ArrayList<Integer> ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str1.nextToken()); // 입력받은 N
        arr = new int[N][N]; // 입력받은 전체 배열
        visited = new boolean [N][N]; //방문했는지 검사하는 체크배열
        ans = new ArrayList<>(); // 전체 단지수를 입력한 배열
        String lines;
        for(int i=0; i<N; i++){
            lines = br.readLine();
            for(int j=0; j<N; j++){
                if(lines.charAt(j) == '0'){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 1 && visited[i][j] == false){
                    cnt = 0;
                    dfs(i, j);
                    ans.add(cnt);
                }
            }
        }
        Collections.sort(ans);
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
    public static void dfs(int x, int y){
        if(arr[x][y] == 0 || visited[x][y] == true || x<0 || y<0 || x>=N || y>=N) {
            return;
        }
        visited[x][y] = true;
        cnt ++;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            dfs(newX, newY);
        }
    }
}

//위아래 + 양옆으로 연결된 경우에만 단지로 취급
// 1) 순회하면서 옆 || 아래로 있음 -> 재귀 + ans++
// 2) 옆 || 아래에 없음 -> return