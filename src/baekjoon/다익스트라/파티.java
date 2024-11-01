package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 파티 {
    static class Node{
        int idx, cost;
        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    static int[] goTo, goHome;
    static int N, M, X;
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        goTo = new int[N+1];
        for(int i=1; i<=N; i++){
            goTo[i] = dijkstra(i)[X];
        }

        goHome = dijkstra(X);

        int maxTime = 0;
        for(int i=1; i<=N; i++){
            if(goTo[i] != Integer.MAX_VALUE && goHome[i] != Integer.MAX_VALUE){
                maxTime = Math.max(maxTime, goTo[i] + goHome[i]);
            }
        }
        System.out.print(maxTime);
    }
    static int[] dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost-n2.cost);
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentIdx = current.idx;
            int currentCost = current.cost;

            if(currentCost > dist[currentIdx]) continue;
            for(Node neighbor: graph.get(currentIdx)){
                int newDist = neighbor.cost + dist[currentIdx];
                if(newDist < dist[neighbor.idx]){
                    dist[neighbor.idx] = newDist;
                    pq.add(new Node(neighbor.idx, newDist));
                }
            }
        }
        return dist;
    }
}
