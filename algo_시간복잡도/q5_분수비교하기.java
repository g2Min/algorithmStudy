package algo_시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5_분수비교하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        long[] arr = new long[4];
        for(int i=0; i<4; i++){
            arr[i] = Long.parseLong(str.nextToken());
        }

        if(arr[0]*arr[3] > arr[2]*arr[1]){
            System.out.print("A/B");
        }else if(arr[0]*arr[3] < arr[2]*arr[1]){
            System.out.print("C/D");
        }else{
            System.out.print("EQUALS");
        }
    }
}

//분수 비교하기
