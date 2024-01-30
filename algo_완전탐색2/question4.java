package algo_완전탐색2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st1.nextToken()); // 입력받은 첫 숫자
        int column = Integer.parseInt(st1.nextToken()); // 입력받은 두번째 숫자
        char[][] arr = new char[row][column]; // 입력받은 그 이후의 문자들
        StringTokenizer st2;
        int cnt1, cnt2; // 반환되고자 하는 결과값
        int result = 64; // 8*8

        for(int i=0; i<row; i++){
            String Str = br.readLine();
            char[] str= Str.toCharArray();
            for(int j=0; j<column; j++){
                arr[i][j] = str[j];
            }
        }

        //입력받은 row=10 이고 index로 따지면 9, 0~9까지 가능row=0~2

        for(int i=0; i<=row-8; i++){ // i와 j는 각 좌표의 행/렬을 뜻한
            for(int j=0; j<=column-8; j++){
                cnt1 = 0;
                cnt2 = 0;
                for(int k=i; k<i+8; k++){
                    for(int l=j; l<j+8; l++){
                        if((k+l)%2==0){ //합이 짝수이면서
                            if(arr[k][l] == 'B') cnt1++; // 그 값이 B인 경우
                            if(arr[k][l] == 'W') cnt2++; // 그 값이 W인 경우
                        }else{ // 합이 홀수면서
                            if(arr[k][l] == 'B') cnt2++;
                            if(arr[k][l] == 'W') cnt1++;
                        }
                    }
                }
//                System.out.println(cnt);
                result = Math.min(result, Math.min(cnt1, cnt2));
            }
        }

        System.out.println(result);

    }
}


// 체스판 색칠놀이
// 8 => W:4 B:4, 7 => W:3 B:4 or W:4 B:3
// 13 => W:7 B:6 or W:6 B:7 해서
// 상대적으로 적은 개수의 W or B를 선택 =>

// 1) 완탐을 이용한 문제 풀이 => 모든 시작점에 대해서 완탐 돌리기
// => (x+y)가 짝수인 경우 =>