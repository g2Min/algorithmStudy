package algo_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ex5_밧줄 {
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 밧줄 개수
        arr = new ArrayList<>();
        for(int i=0; i<N; i++) arr.add(Integer.parseInt(br.readLine()));
        Collections.sort(arr); // 작은 수대로 정렬

        int j=N, sum=0, k=0; // j:가져올 밧줄개수
        while(j>0){
            int temp = sum;
            sum = j*arr.get(k);
            k++;
            j--;
            sum = Math.max(temp, sum);
        }
        System.out.println(sum);
    }
}

// 작은 수대로 정렬 * (N--) 중 최댓값