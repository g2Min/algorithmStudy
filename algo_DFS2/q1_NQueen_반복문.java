package algo_DFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1_NQueen_반복문 {
    private static int N,ans;
    private static int[] arr;
    private static boolean[] line, diag1, diag2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());

        arr = new int[N+1];
        line = new boolean[N+1];
        diag1 = new boolean[2*N+1];
        diag2 = new boolean[2*N+1];

        dfs(1);
        System.out.print(ans);
    }
    public static void dfs(int x){
        if(x==N+1){
            ans++;
            return;
        }
        for(int i=1; i<=N; i++){
            if(line[i] || diag1[x+i] || diag2[x-i+N]){
                continue;
            }
            line[i] = diag1[x+i] = diag2[x-i+N] = true;
            dfs(x+1);
            line[i] = diag1[x+i] = diag2[x-i+N] = false;
        }
    }
}

//NQueen의 각 행을 boolean으로 둬서 check 해가는 방식