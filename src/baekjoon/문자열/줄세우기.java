package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄세우기 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringTokenizer str;
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[N+1][21]; // 식별번호 + 학생 20명
        for(int i=1; i<=N; i++){
            str = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(str.nextToken());
            for(int j=1; j<=20; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            System.out.println(i + " " + func(arr, i));
        }

    }
    private static int func(int[][] arr, int k){
        int ans = 0;

        for(int i=2; i<=20; i++){
            for(int j=1; j<i; j++){
                if(arr[k][i] < arr[k][j]){
                    int temp = arr[k][i];
                    for(int l=i-1; l>=j; l--){
                        arr[k][l+1] = arr[k][l];
                    }
                    arr[k][1] = temp;
                    ans += (i-1);
                }
            }
        }
        return ans;
    }
}

// i=0 부터 생각해서 숫자가 큰게 있으면 맨 앞으로 가고 index 만큼 걸은수가 증가
// 우선 아이들은 항상 20명