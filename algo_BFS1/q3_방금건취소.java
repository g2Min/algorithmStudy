package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class q3_방금건취소 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str1.nextToken()); // 명령어 개수
        StringTokenizer str2;
        Stack<Integer> stack = new Stack<>();
        int num;
        int sum = 0;

        for(int i=0; i<N; i++){
            str2 = new StringTokenizer(br.readLine());
            num = Integer.parseInt(str2.nextToken());
            if(num != 0){
                stack.push(num);
                sum+=num;
            }else{
                int x = stack.pop();
                sum-=x;
            }
        }
        System.out.print(sum);
    }
}

// 0 을 부르면 최근걸 취소 => 큐로 생각하면 될듯