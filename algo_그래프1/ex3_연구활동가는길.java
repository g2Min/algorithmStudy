package algo_그래프1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge{
    private int to, dist;

    public Edge(int to, int dist){
        this.to = to;
        this.dist = dist;
    }
    public int getTo(){
        return this.to;
    }
    public int getDis(){
        return this.dist;
    }
}
public class ex3_연구활동가는길 {
    static ArrayList<ArrayList<Edge>> edge;
    static int[] minDis;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str1.nextToken());
        int M = Integer.parseInt(str1.nextToken());
        edge = new ArrayList<>();
        for(int i=0; i<=N; i++) edge.add(new ArrayList<>());
        StringTokenizer str2;

        while(M-- >0){
            str2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str2.nextToken());
            int v = Integer.parseInt(str2.nextToken());
            int d = Integer.parseInt(str2.nextToken());

            edge.get(u).add(new Edge(v, d));
            edge.get(v).add(new Edge(u, d));
        }
        minDis = new int[N+1];
        dfs(1, 1);
        if(minDis[N] == 0){
            System.out.print("-1");
        }else{
            System.out.println(minDis[N]-1);
        }
    }
    private static void dfs(int v, int d){
        if(minDis[v] != 0 && minDis[v] < d) return;
        minDis[v] = d;
        for(Edge u : edge.get(v)) {
            dfs(u.getTo(), d + u.getDis());
        }
    }
}


