package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 줄세우기 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        int[][] height = new int[P][21];
        StringTokenizer str;
        for(int i=0; i<P; i++){
            str = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(str.nextToken());
            height[i][0] = index;
            for(int j=1; j<=20; j++){
                height[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<P; i++){
            int sum=0;
            for(int j=1; j<=20; j++){ // 처음부터 비교
                for(int k=j-1; k>=1; k--){ // 그 사이 비교값
                    if(height[i][j] < height[i][k]){
                        sum++;
                    }
                }
            }
            sb.append(height[i][0] + " " + sum + "\n");
        }
        System.out.print(sb);
    }
}

// i=0 부터 생각해서 숫자가 큰게 있으면 맨 앞으로 가고 index 만큼 걸은수가 증가
// 우선 아이들은 항상 20명