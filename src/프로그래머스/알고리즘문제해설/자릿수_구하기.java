package 프로그래머스.알고리즘문제해설;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 자릿수_구하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(solution(n));
    }
    public static int solution(int n){
        int answer = 0;
        for(int i=8; i>=0; i--){
            int conf = (int) Math.pow(10, i);
            if(n/conf >= 1){
               answer += n/conf;
               n -= n/conf * conf ;
            }
        }

        return answer;
    }
}
