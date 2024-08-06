package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 모음사전 {
    private static ArrayList<String> list;
    private static String[] vowels = {"A", "E", "I", "O", "U"};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.print(solution(input));
    }
    public static int solution(String word){
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);
        int size = list.size();
        for(int i=0; i<size; i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }

        return answer;
    }
    public static void dfs(String word, int len){
        list.add(word);
        if(len == 5) return;
        for(int i=0; i<5; i++){
            dfs(word + vowels[i], len+1);
        }

    }
}

/* A E I O U => 얘네를 조합해서 1 <= <= 5 의 길이 만들 수 있음
A => 1, 2, 3, 4, 5, 4, 3, 2, 1, 0
* */