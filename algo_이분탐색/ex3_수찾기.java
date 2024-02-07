package algo_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ex3_수찾기 {
    static int N, Q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str1.nextToken()); // 건초개수
        Q = Integer.parseInt(str1.nextToken()); // 질문개수
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        int[] arr = new int[N]; // 건초더미들
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(str2.nextToken());
        }
        Arrays.sort(arr);

        StringTokenizer str3;
        for(int i=0; i<Q; i++){
            str3 = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(str3.nextToken());
            int B = Integer.parseInt(str3.nextToken());

            System.out.println(upperBound(arr, B) - lowerBound(arr, A));
        }

    }
    private static int upperBound(int[] arr, int K ){ // 처음으로 큰수찾기
        int ans = N, l=0, m=0, r=N-1;

        while(l <= r){
            m = (l+r)/2;
            if(arr[m] <= K){
                l = m+1;
            }else{
                ans = m;
                r = m-1;
            }
        }
        return ans+1;
    }
    private static int lowerBound(int[] arr, int K){ // 처음으로 작은 수 찾기
        int ans = N, l=0, m=0, r=N-1;

        while(l <= r){
            m = (l+r)/2;
            if(arr[m] < K){
                l = m+1;
            }else{
                ans = m;
                r = m-1;
            }
        }
        return ans+1;
    }
}