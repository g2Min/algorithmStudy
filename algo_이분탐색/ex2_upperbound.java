package algo_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex2_upperbound {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str1.nextToken()); // 집합크기
        int[] arr = new int[n]; // int 범위 정수집합
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str2.nextToken());
        }
        int k = Integer.parseInt(br.readLine()); // 탐색하려는 값
        System.out.println(upper_bound(arr, n, k));
    }
    private static int upper_bound(int[] arr, int n, int k){ // 처음으로 큰 수가 등장한 위치
        int ans = n;
        int l =0, m=0;
        int r = n-1;
        while (l <= r){
            m = (l+r)/2;
            if(arr[m] <= k){
                l = m+1;
            }else{
                ans = m;
                r = m-1;
            }
        }

        return ans+1; // 위치니까 0번 인덱스는 1번 위치
    }
}
