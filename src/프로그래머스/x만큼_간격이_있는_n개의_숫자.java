package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class x만큼_간격이_있는_n개의_숫자 {
    public static long[] solution(int x, int n){
         long[] answer = new long[n];
         long t = x;
         for(int i=0; i<n; i++){
             answer[i] = t;
             t += x;
         }

         return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        long[] ans = solution(x, n);
        for(int i=0; i<n; i++){
            System.out.println(ans[i]);
        }

    }
}
