package baekjoon.다익스트라;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {
    static class Node{
        int vertex, cost;
        Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }
    static int V, E, K;
    static List<List<Node>> graph;
    static PriorityQueue<Node> pq;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, c));
        }
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
        pq = new PriorityQueue<>((n1, n2) -> n1.cost-n2.cost);
        pq.add(new Node(K, 0));
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentIdx = current.vertex;
            int currentCost = current.cost;

            if(currentCost > dist[currentIdx]) continue;

            for(Node neighbor: graph.get(currentIdx)){
                int newDist = dist[currentIdx] + neighbor.cost;
                if(newDist < dist[neighbor.vertex]){
                    dist[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            if(dist[i] == INF){
                sb.append("INF\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
