package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_회전하기 {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

    }
    public int solution(String s){
        int answer = -1;
        for(int i=0; i<s.length(); i++){
            stack.push(s.charAt(i));
        }

        while(!stack.isEmpty()){

        }

        return answer;
    }
}
