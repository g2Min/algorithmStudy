package algo_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    private int idx, cost;
    public Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
    public int getIdx() { return this.idx; }
    public int getCost() { return this.cost; }

    @Override
    public int compareTo(Node node){
        return Integer.compare(this.cost, node.cost);
    }
}
public class ex2_통행료 {
    static ArrayList<Node>[] graph;
    static int N, M;
    static int sum = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str1.nextToken());
        M = Integer.parseInt(str1.nextToken());
        StringTokenizer str2;
        graph = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1; i<=M; i++){
            str2 = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(str2.nextToken());
            int B = Integer.parseInt(str2.nextToken());
            int C = Integer.parseInt(str2.nextToken());
            graph[A].add(new Node(B, C));
        }

        Dijkstra(N, 1);
        System.out.print(sum);
    }
    public static void Dijkstra(int n, int start){
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            int nowVertex = pq.poll().getIdx();

            // 방문하지 않은 정점에 대해 방문 처리
            if(check[nowVertex]) continue;
            check[nowVertex] = true;

            //index의 연결된 정점 비교
            for(Node next : graph[nowVertex]) {
                if(dist[next.getIdx()] > dist[nowVertex]+ next.getCost()) {
                    dist[next.getIdx()] = dist[nowVertex] + next.getCost();

                    pq.offer(new Node(next.getIdx(), dist[next.getIdx()]));
                }
            }
        }
        //최소거리 출력
        for(int i: dist){
            if(i!=INF) sum+= i;
        }
    }
}
