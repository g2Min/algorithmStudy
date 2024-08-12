package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 멀리_뛰기 {
    static long M = 1234567;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 합산해서 N
        long ans = solution(N) % M;
        System.out.print(ans);
    }
    public static long solution(int n){
        long answer = 0;
        int quo2 = n / 2;
        for(int i=0; i<=quo2; i++){ //2의 몫이 0~B일 때까지
            int quo1 = n - 2*i;
            int sumOf2 = n - i;
            answer += (factorial(sumOf2)) / (factorial(quo1) * factorial(i));
        }

        return answer;
    }
    public static long factorial(int K){
        long ans = 1;
        for(int i=1; i<=K; i++){
            ans *= i;
        }
        return ans;
    }

}

/* 4 => 2 2 / 2 1 1 / 1 1 1 1  (1 + 3!/2! + 1) = 5
A % 2 => B (최대 몫) (2, 1) => (B, A-B), (B-1, A-2*(B-1)), ... (0, B)
* */