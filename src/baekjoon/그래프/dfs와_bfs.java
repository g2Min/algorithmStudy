package baekjoon.그래프;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dfs와_bfs {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); //정점개수
        int M = Integer.parseInt(str.nextToken()); //간선개수
        int V = Integer.parseInt(str.nextToken()); //탐색을 시작할 정점번호
        List<Integer> graph[] = new List[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            str = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(str.nextToken());
            int dst = Integer.parseInt(str.nextToken());
            graph[src].add(dst);
//            graph[dst].add(src);
        }

    }
}

//dfs: 밑으로 탐색하는 것
//bfs: 옆으로 노드를 탐색하는것
//연결리스트로 그래프를 구현하는것 : 각 리스트별로 또 안에 리스트를 구현하는것