package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class JadenCase_문자열_만들기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.print(solution(input));

    }
    public static String solution(String s){
        String answer = "";
        char[] input = s.toCharArray();

        boolean check = true;
        for(int i=0; i<input.length; i++){
            if(check){
                if(!Character.isDigit(input[i])){
                    input[i] = Character.toUpperCase(input[i]);
                    check = false;
                }else{
                    check = false;
                }
            }else{
                if(!Character.isDigit(input[i])){
                    input[i] = Character.toLowerCase(input[i]);
                }
            }

            if(input[i] == ' '){
                check = true;
            }

        }
        return new String(input);
    }
}
