package algo_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex1_dfs와bfs {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static boolean[] check; //해당 노드가 방문했는지를 판별하는 요소
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str1.nextToken());
        M = Integer.parseInt(str1.nextToken());
        V = Integer.parseInt(str1.nextToken());
        StringTokenizer str2;

        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            str2 = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(str2.nextToken());
            int n2 = Integer.parseInt(str2.nextToken());
            arr[n1][n2] = arr[n2][n1] = 1;
        }
        check = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        check = new boolean[N+1];
        bfs(V);
        System.out.print(sb);
    }
    private static void dfs(int start){
        check[start] = true;
        sb.append(start + " ");

        for(int i=0; i<= N; i++){
            if(arr[start][i] == 1 && !check[i]){
                dfs(i);
            }
        }
    }
    private static void bfs(int start){
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()){
            start = queue.poll();
            sb.append(start + " ");
            for(int i=1; i<=N; i++){
                if(arr[start][i] == 1 && !check[i]){
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}

// 먼저 dfs -> bfs 수행
