package baekjoon.슬라이딩_윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값_찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); //슬라이딩 윈도우 크기
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(!deque.isEmpty() && deque.peekFirst()<= i-L){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            sb.append(arr[deque.peekFirst()]).append(" ");
        }
        System.out.print(sb);
    }
}
