package algo_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex2_배식 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr);
        int[] time = new int[N+1];
        time[1] = arr[1];
        for(int i=2; i<=N; i++){
            time[i] = time[i-1] + arr[i];
        }
        int ans = 0;
        for(int i=1; i<=N ;i++){
            ans += time[i];
        }
        System.out.println(ans);
    }
}

// pi = pi + pi-1 (i>1)
// 1 + 3 + 6 + 9 + 13 = 32
// 작은 수대로 배열 후 위에 로직 적용