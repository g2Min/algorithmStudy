package algo_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1_lowerbound {
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

        int l = 0;
        int ans = n;
        int r = n-1;
        while(l <= r){
            int m = (l+r)/2;
            if(arr[m] >= k){
                ans = m;
                r = m-1;
            }else{
                l = m+1;
            }
        }
        System.out.print(ans+1);

    }
}

// 이분탐색