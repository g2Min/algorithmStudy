package algo_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1_증가하는가장긴수열찾기_NxN복잡도 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] LIS = new int[N];
        int maximum = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    LIS[i] = Math.max(LIS[i], LIS[j]);
                }
            }
            LIS[i]++;

            maximum = Math.max(maximum, LIS[i]);
        }
        System.out.println(maximum);
    }
}

// 수열의 순서는 바꿀 수 없고 몇개를 뽑아서 점점 크게