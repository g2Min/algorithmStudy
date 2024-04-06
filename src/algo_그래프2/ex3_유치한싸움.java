package algo_그래프2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex3_유치한싸움 {
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str1.nextToken()); // 학생수
        M = Integer.parseInt(str1.nextToken()); // 조건수

        if(N==0){
            System.out.println("00");
        }else{
            System.out.println("10");
        }

    }
}

// S인경우 동일 D인 경우 다름
// 0: 뱃지x 1: 주황색 2: 하얀색
// 2dml