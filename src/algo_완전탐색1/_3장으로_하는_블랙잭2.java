package algo_완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3장으로_하는_블랙잭2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum = 0;
        for(int i=0; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                for(int k=j+1; k<=N; k++){
                    int total = arr[i] + arr[j] + arr[k];
                    if(total <= M){
                        sum = Math.max(sum, total);
                    }
                }
            }
        }
        System.out.print(sum);
    }
}
