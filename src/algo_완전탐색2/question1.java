package algo_완전탐색2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st1.nextToken()); // 전체 인원
        StringTokenizer st2;
        int[][] arr = new int[num][2]; // 입력하게될 값

        //배열안에 입력값 저장
        for(int i=0; i<num; i++){
            st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        // 순위 배열
        int[] ranks = new int[num];
        // 크기 비교 (내가 원하는 타겟보다 앞에 크기가 큰 수)
        for(int i=0; i<num; i++){
            int bigger = 0;
            for(int j=0; j<num; j++){
                if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]){
                    bigger++;
                }
            }
            ranks[i] = bigger+1;
        }

        //출력
        for(int i=0; i<num; i++){
            System.out.print(ranks[i]+" ");
        }

    }
}

// 1번입력: 전체 변수의 개수
// 2번째부터의 입력: 차례대로
// 등수: 나보다 무거운 사람의 수 +1 이라는 점을 이용한다.

//1) 배열로 계산해도 됨