package algo_그래프2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex2_이분그래프 {
    static int V, E;
    static ArrayList<ArrayList<Integer>> edge;
    static int[] color;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        V = Integer.parseInt(str1.nextToken()); // 정점개수
        E = Integer.parseInt(str1.nextToken()); // 간선개수
        edge = new ArrayList<>();
        for(int i=0; i<V; i++){
            edge.add(new ArrayList<>());
        }
        StringTokenizer str2;
        for(int i=0; i<E; i++){
            str2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str2.nextToken()) - 1;
            int v = Integer.parseInt(str2.nextToken()) - 1;
            edge.get(u).add(v);
            edge.get(v).add(u); // 양방향 그래프
        }
        color = new int[V];
        for(int i=0; i<V; i++){
            color[i] = 0;
        }

        boolean ans = true;
        for(int i=0; i<V; i++){
            if(color[i]==0){
                ans = dfs(i,1);
            }
        }
        if(ans) {
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
    }
    // 모든 정점에 대해서 dfs
    private static boolean dfs(int v, int c){
        if(color[v] == c) return true;
        if(color[v] == 3-c) return false;
        color[v] = c;

        boolean flag = true;
        for(int u: edge.get(v)) flag &= dfs(u, 3-c);
        return flag;
    }
}

// 인접리스트다.