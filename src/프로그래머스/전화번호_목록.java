package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class 전화번호_목록 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] phone = new String[3];

        for(int i=0; i<3; i++){
            phone[i] = br.readLine();
        }

        System.out.print(solution(phone));

    }
    public static boolean solution(String[] phone_book){
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i])
        }

        return answer;
    }
}
