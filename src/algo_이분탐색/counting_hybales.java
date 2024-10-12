package algo_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class counting_hybales {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int t=0; t<Q; t++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = countInRange(arr, start, end);
            System.out.println(cnt);
        }
    }
    static int countInRange(int[] arr, int start, int end) {
        // start 이상의 값이 처음 나오는 위치
        int lowerBound = lowerBound(arr, start);
        // end 이하의 값이 마지막으로 나오는 위치
        int upperBound = upperBound(arr, end);

        // 범위 내에 있는 원소들의 개수는 upperBound - lowerBound
        return upperBound - lowerBound;
    }
    static int lowerBound(int[] arr, int target){
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + (high-low)/2;
            if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    static int upperBound(int[] arr, int target){
        int low = 0;
        int high = arr.length;

        while(low < high){
            int mid = low + (high-low)/2;
            if(arr[mid] <= target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}
