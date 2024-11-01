package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용_구하기 {
    static class Node implements Comparable<Node>{
        int idx, cost;
        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
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
        System.out.print(dist[end]);
    }
}
