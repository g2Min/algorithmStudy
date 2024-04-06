package algo_그래프2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex1_키순서 {
    static int N,M;
    static ArrayList<ArrayList<Integer>> small, tall;
    static boolean[] check = new boolean[N+1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1= new StringTokenizer(br.readLine());
        N = Integer.parseInt(str1.nextToken()); // 전체학생수
        M = Integer.parseInt(str1.nextToken()); // 비교횟수
        StringTokenizer str2;
        small = new ArrayList<>();
        tall = new ArrayList<>();
        for(int i=0; i<N; i++){
            small.add(new ArrayList<>());
            tall.add(new ArrayList<>());
        }

        while(M-- >0){
            str2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str2.nextToken())-1;
            int v = Integer.parseInt(str2.nextToken())-1;
//            small[u].add(v);
            small.get(u).add(v);
            tall.get(v).add(u);
        }
        check = new boolean[N+1];
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) check[j] = false;
            int small_cnt = dfs(small, i) - 1;
            for(int j=0; j<N; j++) check[j] = false;
            int tall_cnt = dfs(tall,i) - 1;
            if(tall_cnt + small_cnt == N-1) cnt++;
        }
        System.out.print(cnt);

    }
    private static int dfs(ArrayList<ArrayList<Integer>> edge, int v){
        if(check[v]) return 0; // 이미 방문했다면 0반환
        check[v] = true; // 방문안했으면 true로 저장

        int cnt = 1;
        for(int u : edge.get(v)) cnt += dfs(edge, u);
        return cnt;
    }
}

// 인접리스트
// 자신의 키를 알려면 자신보다 (위에 있는 사람) + (아래에 있는 사람) = N-1
//