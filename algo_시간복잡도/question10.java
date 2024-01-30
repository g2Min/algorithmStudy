package algo_시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question10 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        String[][] arr = new String[7][7];
        //입력값 받아내기
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                str = new StringTokenizer(br.readLine());
                arr[i][j] = str.nextToken();
            }
        }
        int sum = 0;
        int cnt1 = 0; //o가 이기는 경우
        int cnt2 = 0; //x가 이기는 경우
        // 아래로, 대각선으로 0~4,1~5 .. 3~7
        for(int i=0; i<=3; i++){
            for(int j=0; j<7; j++){
                if(arr[i][j] == "o"){

                }
            }
        }
        // 옆으로 1~5, 2~6, 3~7


    }
}


// 오목판담
// o win => o| x win => x| no winner => . 출력값
// 처음 발견하고 i) 옆으로가느냐 ii) 아래로 가느냐 iii) 대각선으로 가느냐