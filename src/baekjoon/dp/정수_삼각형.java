package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 정수_삼각형 {
    public static  void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> triangle = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<=i; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            triangle.add(list);
        }
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            dp[i] = triangle.get(N-1).get(i);
        }
        for(int i=N-2; i>=0 ;i--){
            for(int j=0; j<=i; j++){
                dp[j] = triangle.get(i).get(j) + Math.max(dp[j], dp[j+1]);
            }
        }
        System.out.print(dp[0]);
    }
}
