package algo_완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question6 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(str.nextToken()); // 빨간색 타일
        int B = Integer.parseInt(str.nextToken()); // 갈색 타일
        int[] arr= new int[2];
        for(int i=3; i*2<=R-2; i++){

        }
        System.out.println(arr[0] + " " + arr[1]);
    }
}

// 가장자리는 빨간색 그 안에는 갈색
// 첫과 마지막 줄은 모두 빨간색

// j<=i-2, j*2<=