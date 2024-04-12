package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2_N과M2_re {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[M]; // 매번 업데이트되는 수열

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int x) {
        if (x >= M) { // x=0 부터 시작하므로 마지막 시도가 M+1
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        if (x == 0) { // 처음 시작인 경우
            for (int i = 1; i <= N; i++) {
                arr[x] = i;
                dfs(x + 1);
                arr[x] = 0; // 백트래킹
            }
        } else { // 두번째부터
            for (int i = arr[x-1] + 1; i <= N; i++) {
                arr[x] = i;
                dfs(x + 1);
                arr[x] = 0;
            }
        }
    }

}

// 중복없이 오름차순