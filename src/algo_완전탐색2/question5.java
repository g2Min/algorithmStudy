package algo_완전탐색2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class question5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(str1.nextToken()); // 배열 크기
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        // 입력받을 배열 크기
        for( int i=0; i<num; i++){
            arr[i] = Integer.parseInt(str2.nextToken());
        }
        //입력받은 배열 오름차순 정렬
        Arrays.sort(arr);

        int cnt = num; // 단일 구간 = 자기자신이 가능하므로 배열의 크기

        //다중 구간이 배열내의 숫자에 있는지
        for(int i=0; i<num-1; i++){
            for(int j=i+1; j<num; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += arr[k];
                }
                for(int l=i; l<=j; l++){
                    if(sum == (j-i+1) * arr[l]) {
                        cnt++;
                        break;
//                        System.out.println(arr[i] + " " + arr[j] + " " + arr[l] + " " + sum);
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
//평균이 들어있는 구간 구하기
// 원하는 i,와 j는 결국 배열의 몇번째 위치인지를 의미하는 듯
// 1) 정렬하기가 필요할 듯
// 2) 동일한 숫자면 겹쳐져도 되고
// 3) a + b = 2 * c 이게 만족하면 ++
// 단일구간) 모든 수를 더함, 다중구간) 구간내의 모든 수가 배열안에 있는지

/*
* if(arr[i]+arr[j] == 2 * arr[k] && arr[i] != arr[k]){
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                        cnt++;
                    }
* */