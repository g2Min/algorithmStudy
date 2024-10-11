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
            int cnt = 0;
            for(int k=0; k<N; k++){
                if(binarySearch(start,end,arr[k])){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
    static boolean binarySearch(int start, int end, int target){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid < target){
                start++;
            }else if(mid > target){
                end--;
            }else{
                return true;
            }

        }
        return false;
    }
}
