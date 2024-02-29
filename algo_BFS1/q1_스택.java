package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q1_스택 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        String line;
        int num;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<100000; i++){
            str = new StringTokenizer(br.readLine());
            line = str.nextToken();

            if(line.equals("end")) break;

            if(line.equals("size")){
                int x = stack.size();
                sb.append(x+"\n");
            }

            if(line.equals("empty")){
                Boolean isEmpty = stack.empty();
                if(isEmpty) sb.append("1\n");
                else sb.append("0\n");
            }

            if(line.equals("push") && str.hasMoreTokens()){
                num = Integer.parseInt(str.nextToken());
                stack.push(num);
                sb.append( num+"\n");
            }

            if(line.equals("top")){
                if(stack.empty()){
                    sb.append("-1\n");
                    continue;
                }
                int x = stack.peek();
                sb.append(x+"\n");
            }

            if(line.equals("pop")){

                if(stack.empty()){
                    sb.append("-1\n");
                    continue;
                }
                int x = stack.pop();
                sb.append(x+"\n");
            }
        }

        System.out.print(sb);
    }
}
