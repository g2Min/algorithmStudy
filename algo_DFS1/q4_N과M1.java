package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4_N과M1 {
    private static int N, M;
    private static int[] arr;
    private static boolean[] check;
    private static StringBuilder ans= new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[M]; // 한 줄에 들어가게 되는 배열
        check = new boolean[N+1]; // 체크하려는 대상이 1부터 N까지의 수이므로

        dfs(0);
        System.out.print(ans);
    }
    public static void dfs(int x){
        if(x == M){
            for(int i=0; i<M; i++){
                ans.append(arr[i]).append(" ");
            }
            ans.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(check[i] == true) continue;
            arr[x] = i;
            check[i] = true;
            dfs(x+1);
            arr[x] = 0;
            check[i] = false;
        }
    }
}

// N과 M1
// "중복없이" => check 배열을 만들어본다.