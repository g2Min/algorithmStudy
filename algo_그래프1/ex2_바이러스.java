package algo_그래프1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex2_바이러스 {
    static ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // 전체 컴퓨터 개수
        int N = Integer.parseInt(br.readLine()); // edge 개수
        for(int i=0; i<=num; i++){
            edge.add(new ArrayList<Integer>());
        }
        StringTokenizer str;
        while(N-- > 0){
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            edge.get(u).add(v);
            edge.get(v).add(u);
        }
        check = new boolean[num+1];
        System.out.println(dfs(1) - 1);
    }
    private static int dfs(int start){
        if(check[start]) return 0;
        check[start] = true;

        int sum = 1 ;
        for(int u: edge.get(start)) sum+=dfs(u);

        return sum;
    }
}