package algo_완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1_콜라배달 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int result = -1;
        int BoxNum1=0;
        int BoxNum2=0;

        // brute force 방식

//        for(int i=0; i*3<=N; i++){
//            for(int j=0; j*5<=N; j++){
//                int Total = i*3 + j*5;
//                if(Total == N){
//                    int BoxNum = i + j;
//                    if(result == -1 || result>BoxNum){
//                        result = BoxNum;
//                    }
//                }
//            }
//        }
//        System.out.println(result);

        //order(n)방식
        for(int i=0; i*3 <=N; i++){
            if((N-i*3)%5 == 0){
                int j =(N-i*3) % 5;
                BoxNum1 = i+j;
            }
        }
        for(int i=0; i*5 <=N; i++){
            if((N-i*5)%3 == 0){
                int j = (N-i*5) % 3;
                BoxNum2 = i+j;
            }
        }
        if(BoxNum1 > BoxNum2) {
            System.out.println(BoxNum2);
        }else{
            System.out.println(BoxNum1);
        }

    }
}

// 콜라배달