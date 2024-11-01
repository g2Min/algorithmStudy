package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 텀_프로젝트 {
    static int N;
    static int[] stu;
    static boolean[] visited, done;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            res = 0;
            stu = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                stu[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[N+1];
            done = new boolean[N+1];
            for(int i=1; i<=N; i++){
                if(!done[i]){
                    dfs(i);
                }
            }
            System.out.println(N-res);
        }
    }
    static void dfs(int idx){
        if(done[idx]) return;
        if(visited[idx]){
           done[idx] = true;
           res++;
        }
        visited[idx] = true;
        dfs(stu[idx]);
        done[idx] = true;
        visited[idx] = false;
    }
}
