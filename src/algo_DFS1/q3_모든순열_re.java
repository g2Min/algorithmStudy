package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q3_모든순열_re {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //입력받은 숫자
        arr = new int[N + 1]; // 배열에 넣는 숫자 (1번 index부터) - 안헷갈리게
        visited = new boolean[N + 1]; // 1~N 까지의 숫자들 방문 여부

        dfs(1);
        System.out.print(sb);
    }

    public static void dfs(int x) {// x: 배열의 위치
        if (x >= N + 1) {
            for (int i = 1; i <= N; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            arr[x] = i;
            visited[i] = true;
            dfs(x + 1);
            arr[x] = 0;
            visited[i] = false;
        }
    }
}

