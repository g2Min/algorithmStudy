package 프로그래머스.코딩test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타겟_넘버 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        return answer;
    }
}

/* 입력값: 4, [ 1 1 1 1 1 ], 3
* */