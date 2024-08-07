package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산 {
    private static List<Integer>[] list;
    private static int res = -1;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int q1 = Integer.parseInt(st.nextToken());
        int q2 = Integer.parseInt(st.nextToken()); // q1 과 q2는 내가 알아내야 하는 촌수관계
        int M = Integer.parseInt(br.readLine()); // 관계개수
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(q1, q2, 0);
        System.out.print(res);
    }
    public static void dfs(int start, int end, int cnt){
        if(start == end){
            res = cnt;
            return;
        }
        visited[start] = true;
        for(int i=0; i<list[start].size(); i++){
            int next = list[start].get(i);
            if(!visited[next]){
                dfs(next, end, cnt+1);
            }
        }

    }
}

/* x - y : x 는 y의 부모
* */