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
        for(int i=0; i<number.length()-k; i++){
            int cnt = number.length()-k; // 선택해야하는 숫자 개수
            StringBuilder sb = new StringBuilder();
            dfs(cnt, i, sb);
        }

        Collections.sort(list, Collections.reverseOrder());

        String answer = list.get(0).toString();
        return answer;
    }
    public static void dfs(int count, int stIndex, StringBuilder sb){
        if(count == 0){ // 더이상 선택할 숫자가 없을때
            String num = sb.toString();
            list.add(Integer.parseInt(num));
            return;
        }
        sb.append(arr[stIndex]);
        for(int i=stIndex+1; i<arr.length; i++){
            count --;
            dfs(count, i, sb);
        }
    }
}
