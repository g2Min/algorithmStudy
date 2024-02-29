package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q4_조세퍼스 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // N명 (1번 ~N번)
        int M = Integer.parseInt(str.nextToken()); // M의 배수
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            for(int i=1; i<M; i++){ // M-1개는 뒤로 보내고
                int x = queue.poll();
                queue.offer(x);
            }
            int x = queue.poll(); // 마지막 M번째를 꺼내게끔
            sb.append(x + " ");
        }

        System.out.print(sb);
    }
}

// M의 배수 => M번째 사람 제거
// 출력하고 싶은 순열은 처음 들어온 사람부터 linkedlist로 가져올 것
// 만약 N명이 있다면 1번 사람은 1+(남은사람 수) 를 부르게 될 것이다. => 남은사람은 size
