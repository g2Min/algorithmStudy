package algo_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex5_케이블자르기 {
    static int N, M;
    static long[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str1.nextToken()); // 갖고있는 케이블 개수
        M = Integer.parseInt(str1.nextToken()); // 필요한 케이블 개수
        arr = new long[N]; // 입력받을 케이블 길이들
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

    }
    private static int upperBound(){
        long l=0; // 첫 시작
        long m=0;
        long r=2^31;

        while(l<r){
            m=(l+r+1)/2;
            int sum = 0; // 각 케이블에서 잘려나갈 케이블 수

        }

        return 0;
    }
}

// 이분탐색 => m을 설정해서 그만큼 나눈 몫들의 합이 원하는 값이상 나오면 되게끔 하는 최댓값
