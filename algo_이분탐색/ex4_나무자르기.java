package algo_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex4_나무자르기 {
    static int N; // 나무수
    static long M; // 10^10 범위
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str1.nextToken()); // 나무의 수
        M = Long.parseLong(str1.nextToken()); // 최소 나무길이
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        int[] trees = new int[N]; // 나무길이에 대한 배열
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(str2.nextToken());
        }
        Arrays.sort(trees);
        System.out.print(upperBound(trees));
    }

    private static long upperBound(int[] arr) {
        long l=0;
        long m = 0;
        long r = 1000000000;
        while(l<r){
            m = (l+r+1)/2;
            long sum = 0;
            for(int i=0; i<N; i++){
                sum+=arr[i] > m ? arr[i]-m : 0;
            } // i번째 배열 값이 m보다 큰경우 더하는거
            if(sum >= M ) l=m;
            else r = m-1;
        }
        return l;
    }
}

// 탐색하려는 값은 100~00 이하의 정수 를 탐색
// 1. 정렬 2. upperbound => mid 값을 잡고 sum > 충분한지