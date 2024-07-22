package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class n2배열자르기 {
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];

        for (long i = left; i <= right; i++) {
            int row = (int)(i / n);
            int col = (int)(i % n);
            answer[(int)(i - left)] = Math.max(row, col) + 1;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long left = Long.parseLong(br.readLine());
        long right = Long.parseLong(br.readLine());

        int[] ans = solution(N, left, right);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}

/* int[n+1][n+1]
for m=1~i
for n=1~i 까지 arr[m][n] = i
행들을 모두 이어붙인 1차원 배열 => arr
arr[left~right] 만 남김
* */