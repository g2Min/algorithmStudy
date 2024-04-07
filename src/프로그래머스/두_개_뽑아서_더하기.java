package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 두_개_뽑아서_더하기 {
    public static int[] solution(int[] numbers) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum =  numbers[i] + numbers[j];
                ans.add(sum);
            }
        }

        Collections.sort(ans);
        ArrayList<Integer> ansArray = new ArrayList<>();
        for(int num: ans){
            if(!ansArray.contains(num))
                ansArray.add(num);
        }

        int[] answer = ansArray.stream()
                .mapToInt(i -> i)
                .toArray();
        return answer;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] numbers = new int[str.countTokens()];
        for(int i=0; i<str.countTokens(); i++){
            numbers[i] = Integer.parseInt(str.nextToken());
        }

        int[] answer = solution(numbers);
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
