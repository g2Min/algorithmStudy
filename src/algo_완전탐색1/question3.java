package algo_완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question3 {
    public  static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int cards = Integer.parseInt(str.nextToken()); // cards 만큼 카드의 수가 존재함
        int M = Integer.parseInt(str.nextToken()); // 제한을 넘지 않는 수
        StringTokenizer str2 = new StringTokenizer(br.readLine()); // 두번째 수
        int[] arr = new int[cards];
        for(int i=0; i<cards; i++){
            arr[i] = Integer.parseInt(str2.nextToken()); // 가지고 있는 카드 숫자들
        }
        int result = 0; // 알아내고 싶은 값

        // order(n^3)
        for(int i=0; i<cards-2; i++){
            for(int j=i+1; j<cards-1; j++){
                for(int k=j+1; k<cards; k++){
                    int Total = arr[i] + arr[j] + arr[k];
//                    System.out.println(Total);
                    //Total이 result보다는 이하지만 그 값이 result중에 최대인 경우
                    if(Total <= M && result < Total){
                        result = Total;
                    }
                }
            }
        }
        System.out.println(result);

//        //order(n)
//        for(int i=0; i<cards-2; i++){
//            for(int j=i+1; j<cards-; j++){
//                if(arr[i] == arr[j]){
//
//                }
//            }
//        }
    }
}
// |원하는값 - M| 가 가장 작은 것
// 두번째 줄을 돌아가면서 합을 구하고 그 합과 M의 차이를 구함

// 1) 3개의 반복문을 돌면서 각각의 안