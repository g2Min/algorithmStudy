package algo_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex6_대표자연수 {
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 자연수 개수
        arr = new ArrayList<>();
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr.add(Integer.parseInt(str.nextToken()));

        Collections.sort(arr);

//        int j=0, sum=0, ans=0;
//        while(j<N){
//            int temp = sum;
//            sum = 0;
//            for(int k=0; k<N; k++){
//                sum+= Math.abs(arr.get(k) - arr.get(j));
//            }
//            if(sum < temp){
//                ans = arr.get(j);
//            }
//            j++;
//        }
//        System.out.println(ans);
        System.out.print(arr.get((N-1)/2));

    }
}

// 처음부터 정렬을 돌면서 그 차이가 최소인 경우