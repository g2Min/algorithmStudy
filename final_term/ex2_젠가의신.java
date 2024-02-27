package final_term;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex2_젠가의신 {
    static int N;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //나무토막 횟수
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1]; //원조배열
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        func(arr);
        System.out.println(ans);
    }
    public static void func(int[] arr){
        int index = -1;
        int i=1;
        while(i<=N){
            int temp = arr[i]; // 이전 arr값
            i++;
            int min = Math.min(temp, arr[i]); // 가장 작은 값
            index = Arrays.asList(arr).indexOf(min);
        }
        if(index == -1) return; // 오름차순인 경우


    }
}
