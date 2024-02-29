package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class q5_선입선출 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str1.nextToken());
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(str2.nextToken());
            queue.offer(x);
        }



    }
}

// FIFO => 큐 , FILO => 스택(바뀐부분)
// 스택의 첫번째 보다 큰게 하나라도 있는 경우 뒤로 보내기 
// 가장 첫번째 과자가 언제 pop되는지