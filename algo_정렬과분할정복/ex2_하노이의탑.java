package algo_정렬과분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex2_하노이의탑 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 원판의 개수 (N -- 1)

        System.out.println((1<<N) -1);
        hanoi(N,1,3);
    }
    static void hanoi(int n, int start, int end){
        if(n==0) return;

        int mid = 6-start-end;
        hanoi(n-1, start, mid);
        System.out.println(start + " " + end);
        hanoi(n-1, mid, end);
    }
}

// n개의 원판 1->3 장대로 이동
// (321) 0 0
// (32) 0 (1)
// (3) (2) (1)
// (3) (21) (0)
// 0 (21) (3)
// (1) (2) (3)
// (1) 0 (32)
// 0 0 (321)