package algo_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class upper_bound {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());


        if(arr[N-1] < K){
            System.out.print(N+1);
        }else{
            System.out.print(upper_bound(arr, N, K));
        }
    }
    public static int upper_bound(int[] arr, int N, int K){
        int l=0, r=N;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid] <= K){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return r+1;
    }
}
