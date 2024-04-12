package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4_N과M1_re {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[M + 1]; //M개의 배열로 숫자 넣기
        visit = new boolean[N + 1]; //N개의 숫자들에 대해 참거짓
        dfs(1);
        System.out.print(sb);
    }

    public static void dfs(int x) {// 현재 index
        if (x >= M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            arr[x] = i;
            visit[i] = true;
            dfs(x + 1);
            arr[x] = 0;
            visit[i] = false;
        }
    }

}
