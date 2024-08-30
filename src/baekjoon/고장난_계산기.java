package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 고장난_계산기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수식의 길이
        int P = Integer.parseInt(st.nextToken()); // 법 P
        String input = br.readLine(); // 수식 s
        System.out.print(solution(input));
    }
    private static String solution(String expr){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<expr.length(); i++){
            char c = expr.charAt(i);
            if(c=='+' || c=='*'){
                sb.insert(0, '(');
                sb.append(')');
            }
            sb.append(c);
        }

        while(!stack.isEmpty()){
            sb.append(')');
            stack.pop();
        }
        return sb.toString();
    }
}
