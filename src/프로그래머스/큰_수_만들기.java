package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 큰_수_만들기 {
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int k = Integer.parseInt(br.readLine());
        System.out.print(solution(input, k));
    }
    public static String solution(String number, int k){
        arr = new int[number.length()];
        for(int i=0; i<number.length(); i++){
            arr[i] = number.charAt(i) - '0';
        }
        int pick = number.length() - k; // 선택해야하는 숫자개수
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        for(int i=0; i<pick; i++){
            int max = 0;
            for(int j= startIndex; j<= k+i; j++){
                if(arr[j] > max){
                    max = arr[j];
                    startIndex = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

}
