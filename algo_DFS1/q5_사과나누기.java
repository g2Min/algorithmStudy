package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5_사과나누기 {
    private static int N;
    private static int[] arr;
    private static long mini, diff;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str1.nextToken());
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        arr = new int[N+1]; // 전체 사과 무게
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(str2.nextToken());
        }

        dfs(0, 0);
        System.out.print(mini);
    }
    public static void dfs(int x, long diff){
        if(x == N){
            diff = Math.abs(diff);
            mini = Math.min(mini, diff);
            return;
        }

        dfs(x+1, diff+arr[x+1]);
        dfs(x+1, diff-arr[x+1]);
    }
}

// 사과나누기
// 3 | 2+7+4+1 => 차이 알아두고 => min으로 계산
// 3+2 | 7+4+1
// 위에서 나누는건 "중복없이" 나누는 것과 동일함
// 필요변수 1)합변수 2)check배열
// 합변수 (전자) 먼저 구하고 (후자) 전체 합-전자 (차이값) |전자-후자| 의 min