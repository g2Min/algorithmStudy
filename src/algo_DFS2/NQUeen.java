package algo_DFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQUeen {
    static int[][] arr;
    static int N;
    static int ans = 0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dfs(1);
        System.out.print(ans);
    }
    static void dfs(int x){
        if(x==N){
            ans ++;
            return;
        }

        for(int i=0; i<N; i++){
            boolean pos = true;
            for(int j=0; j<x; j++){
                if(i == arr[j] || j - arr[j] == x-i || j + arr[j] == x+i){
                    pos = false;
                }
            }

            if(pos){
                arr[x] = i;
                dfs(x+1);
                arr[x] = 0;
            }
        }
    }
}
