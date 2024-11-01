package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
        goHome = new int[N+1];
        int[] res = new int[N+1];
        goTo[X] = goHome[X] = 0;

        for(int i=1; i<=N; i++){
            int[] arr = dijkstra(i, goTo);
        }

    }
    static int[] dijkstra(int start, int[] arr){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost-n2.cost);
        pq.add(new Node(X, 0));
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentIdx = current.idx;
            int currentCost = current.cost;
            if(currentCost > arr[currentIdx]) continue;
            for(Node neighbor: graph.get(currentIdx)){
                int newDist = neighbor.cost + arr[currentIdx];
                if(newDist < arr[neighbor.idx]){
                    arr[neighbor.idx] = newDist;
                }
            }
        }
        return arr;
    }
}
