package algo_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex1_증가하는가장긴수열찾기_nlogn {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력받을 숫자 개수
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] LIS = new int[N];
        int max = 0;
        ArrayList<Integer> K = new ArrayList<>();
        K.add(0);
        for(int i=0; i<N; i++){
            int X = Integer.parseInt(str.nextToken());
            LIS[i] = lowerBound(K, X);

            if(LIS[i] == K.size()) K.add(X);
            K.set(LIS[i], X);

            max = Math.max(max, LIS[i]);
        }
        System.out.print(max);
    }
    public static void lower_bound(int n, int[] arr, int k){
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
    }
    public static int lowerBound(ArrayList<Integer> list, int x){
        return 0;
    }
}
